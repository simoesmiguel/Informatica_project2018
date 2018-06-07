package org.owntracks.android.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.LongSparseArray;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;
import org.owntracks.android.App;
import org.owntracks.android.messages.MessageBase;
import org.owntracks.android.messages.MessageCard;
import org.owntracks.android.messages.MessageClear;
import org.owntracks.android.messages.MessageCmd;
import org.owntracks.android.messages.MessageLocation;
import org.owntracks.android.messages.MessageTransition;
import org.owntracks.android.messages.MessageUnknown;
import org.owntracks.android.messages.MessageWaypoint;
import org.owntracks.android.messages.MessageWaypoints;
import org.owntracks.android.support.Events;
import org.owntracks.android.support.IncomingMessageProcessor;
import org.owntracks.android.support.Preferences;
import org.owntracks.android.support.widgets.Toasts;
import org.owntracks.android.support.interfaces.ProxyableService;
import org.owntracks.android.support.interfaces.ServiceMessageEndpoint;
import org.owntracks.android.support.interfaces.StatefulServiceMessageEndpoint;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import timber.log.Timber;


public class ServiceMessage implements ProxyableService, IncomingMessageProcessor {
    private static final String TAG = "ServiceMessage";
    public static final String RECEIVER_ACTION_CLEAR_CONTACT_EXTRA_TOPIC = "RECEIVER_ACTION_CLEAR_CONTACT_EXTRA_TOPIC" ;
    public static final String RECEIVER_ACTION_CLEAR_CONTACT = "RECEIVER_ACTION_CLEAR_CONTACT";

    private static ServiceMessageEndpoint endpoint;
    private ThreadPoolExecutor incomingMessageProcessorExecutor;

    private ServiceProxy context;

    public void reconnect() {
        if(endpoint instanceof StatefulServiceMessageEndpoint)
            StatefulServiceMessageEndpoint.class.cast(endpoint).reconnect();
    }

    public void disconnect() {
        if(endpoint instanceof StatefulServiceMessageEndpoint)
            StatefulServiceMessageEndpoint.class.cast(endpoint).disconnect();
    }

    public ServiceProxy getContext() {
        return context;
    }

    public enum EndpointState {
        INITIAL,
        IDLE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED,
        DISCONNECTED_USERDISCONNECT,
        ERROR,
        ERROR_DATADISABLED,
        ERROR_CONFIGURATION;

        public String getLabel(Context context) {
            Resources res = context.getResources();
            int resId = res.getIdentifier(this.name(), "string", context.getPackageName());
            if (0 != resId) {
                return (res.getString(resId));
            }
            return (name());
        }

        public boolean isErrorState() {
            return this == ERROR || this == ERROR_DATADISABLED || this == ERROR_CONFIGURATION;
        }
    }



    @Override
    public void onCreate(ServiceProxy c) {
        this.context = c;
        this.incomingMessageProcessorExecutor = new ThreadPoolExecutor(2,2,1,  TimeUnit.MINUTES,new LinkedBlockingQueue<Runnable>());
        onEndpointStateChanged(EndpointState.INITIAL);
        try {
            endpoint = instantiateEndpoint(Preferences.getModeId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private @NonNull ServiceMessageEndpoint instantiateEndpoint(int mode) throws Exception{
        Timber.v("mode:%s", mode);
        if(endpoint != null) {
            Timber.v("destroying endpoint");
            endpoint.onDestroy();
        }

        Timber.v("instantiating new endpoint");
        ServiceMessageEndpoint p = null;
        switch (mode) {
            case App.MODE_ID_HTTP_PRIVATE:
                p = new ServiceMessageHttp();
                break;
            case App.MODE_ID_MQTT_PRIVATE:
            case App.MODE_ID_MQTT_PUBLIC:
                p = new ServiceMessageMqtt();
                break;
        }

        if(p == null) {
            Timber.e("unable to instantiate endpoint for mode:%s", mode);
            throw new Exception("endpoint instantiation faield");
        }

        p.onCreate(context);
        p.onSetService(this);
        App.getEventBus().register(p);
        return p;
    }

    @Override
    public void onDestroy() {
        Timber.d("onDestroy");
        if(endpoint != null)
            endpoint.onDestroy();
    }

    @Override
    public void onStartCommand(Intent intent) {
        if (endpoint != null)
            endpoint.onStartCommand(intent);

    }

    @Subscribe
    public void onEvent(Events.Dummy event) {

    }

    @Subscribe
    public void onEvent(Events.ModeChanged event) {
        try {
            endpoint = instantiateEndpoint(Preferences.getModeId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private LongSparseArray<MessageBase> outgoingQueue = new LongSparseArray<>();

    void sendMessage(MessageBase message) {
        Timber.v("endpoint:%s, message:%s",endpoint, message);

        message.setOutgoing();
        try {

            if(endpoint == null) {
                Timber.e("no endpoint, creating on demand");
                endpoint = instantiateEndpoint(Preferences.getModeId());
            }

            if(!endpoint.isReady()) {
                Timber.e("endpoint is not ready: %s", endpoint);
                endpoint.probe();
                return;
            }

            if(endpoint.sendMessage(message)) {
                this.onMessageQueued(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



     void onMessageDelivered(Long messageId) {
        MessageBase m = outgoingQueue.get(messageId);
        outgoingQueue.remove(messageId);

        if(m == null) {
            Log.e(TAG, "onMessageDelivered()- messageId:"+messageId + ", error: called for unqueued message");
        } else {
            Log.v(TAG, "onMessageDelivered()-  messageId:" + m.getMessageId()+", queueLength:"+outgoingQueue.size());
            if(m instanceof MessageLocation) {
                App.getEventBus().post(m);
            }
        }
    }

    private void onMessageQueued(MessageBase m) {
        outgoingQueue.put(m.getMessageId(), m);

        Log.v(TAG, "onMessageQueued()- messageId:" + m.getMessageId()+", queueLength:"+outgoingQueue.size());
        if(m instanceof MessageLocation && MessageLocation.REPORT_TYPE_USER.equals(MessageLocation.class.cast(m).getT()))
            Toasts.showMessageQueued();
    }

    public void onMessageDeliveryFailed(Long messageId) {

        MessageBase m = outgoingQueue.get(messageId);
        outgoingQueue.remove(messageId);

        if(m == null) {
            Timber.e("type:base, messageId:%s, error: called for unqueued message", messageId);
        } else {
            Timber.e("type:base, messageId:%s, queueLength:%s", messageId, outgoingQueue.size());
            if(m.getOutgoingTTL() > 0)  {
                Timber.e("type:base, messageId:%s, action: requeued",m.getMessageId() );
                sendMessage(m);
            } else {
                Timber.e("type:base, messageId:%s, action: discarded due to expired ttl",m.getMessageId() );
            }
        }
    }

    public void onMessageReceived(MessageBase message) {
        message.setIncomingProcessor(this);
        message.setIncoming();
        incomingMessageProcessorExecutor.execute(message);
    }

    public void onEndpointStateChanged(EndpointState newState) {
        App.getEventBus().postSticky(new Events.EndpointStateChanged(newState));
    }

    public void onEndpointStateChanged(EndpointState newState,  String message) {
        App.getEventBus().postSticky(new Events.EndpointStateChanged(newState, message));
    }

    public void onEndpointStateChanged(EndpointState newState, Exception e) {
        Timber.v("new state:%s",newState);
        App.getEventBus().postSticky(new Events.EndpointStateChanged(newState, e));
    }


    @Override
    public void processIncomingMessage(MessageBase message) {
        Timber.v("type:base, key:%s", message.getContactKey());
    }

    public void processIncomingMessage(MessageUnknown message) {
        Timber.v("type:unknown, key:%s", message.getContactKey());
    }

    @Override
    public void processIncomingMessage(MessageClear message) {
        App.getContactsRepo().remove(message.getContactKey());
    }


    @Override
    public void processIncomingMessage(MessageLocation message) {
        System.out.println("<Service Message> processIncomingmessage ======================= ");
        if(message.getMessageType() !=null) {
            // check if message.messageDestinationId != mymobile number
            String mymobileNumber= getMyMobileNumber();
            System.out.println("<ServiceMessage> MyMobileNumber: "+mymobileNumber);
            if(mymobileNumber!=null && message.getMessageDestinationId()!=null && message.getMessageDestinationId().equals( mymobileNumber)) { //check if the user is the recipient of the message
                switch (message.getMessageType()) {
                    case "coords":
                        App.getContactsRepo().update(message.getContactKey(), message);
                        break;
                    case "address":
                        System.out.println("ADDRESS :: " + message.getAddress());
                        Intent intent2 = new Intent(Intent.ACTION_SEND);
                        intent2.setType("text/plain");

                        PackageManager packageManager = context.getPackageManager();
                        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent2, 0);
                        boolean isIntentSafe = activities.size() > 0;

                        // Start an activity if it's safe
                        if (isIntentSafe) {
                            for (ResolveInfo activity : activities) {
                                if (activity.activityInfo.packageName.contains("currentplacedetailsonmap")) {
                                    intent2.setData(Uri.parse("receiver_address://123"));
                                    intent2.setPackage(activity.activityInfo.packageName);
                                    intent2.putExtra("address", message.getAddress());
                                    intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    context.sendBroadcast(intent2);
                                }
                            }
                        }
                        break;
                    case "meetingPoint":{
                        System.out.println("MeetingPoint :: " + message.getMeetingPoint());
                        Intent intent4 = new Intent(Intent.ACTION_SEND);
                        intent4.setType("text/plain");

                        PackageManager packageManager4 = context.getPackageManager();
                        List<ResolveInfo> activities4 = packageManager4.queryIntentActivities(intent4, 0);
                        boolean isIntentSafe4 = activities4.size() > 0;

                        // Start an activity if it's safe
                        if (isIntentSafe4) {
                            for (ResolveInfo activity : activities4) {
                                if (activity.activityInfo.packageName.contains("currentplacedetailsonmap")) {
                                    intent4.setData(Uri.parse("receiver_address://123"));
                                    intent4.setPackage(activity.activityInfo.packageName);
                                    intent4.putExtra("meetingPoint", message.getMeetingPoint());
                                    intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    context.sendBroadcast(intent4);
                                }
                            }
                        }

                        break;
                    }
                    case "geohash":
                        Intent intent3 = new Intent(Intent.ACTION_SEND);
                        intent3.setType("text/plain");

                        PackageManager packageManager2 = context.getPackageManager();
                        List<ResolveInfo> activities2 = packageManager2.queryIntentActivities(intent3, 0);
                        boolean isIntentSafe2 = activities2.size() > 0;

                        // Start an activity if it's safe
                        if (isIntentSafe2) {
                            for (ResolveInfo activity : activities2) {
                                if (activity.activityInfo.packageName.contains("currentplacedetailsonmap")) {
                                    intent3.setData(Uri.parse("receiver_address://123"));
                                    intent3.setPackage(activity.activityInfo.packageName);
                                    intent3.putExtra("isInGeohash", message.getGeoHashJSON());
                                    intent3.putExtra("coords", new double[]{message.getLatitude(), message.getLongitude()});
                                    intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    context.sendBroadcast(intent3);
                                }
                            }
                        }
                        break;
                }
            }else{

                if(message.getMessageType().equals("coords")){
                    App.getContactsRepo().update(message.getContactKey(), message);
                }else
                    Log.v("<ServiceMessage> ","This message was not for me");
            }
        }else
            App.getContactsRepo().update(message.getContactKey(), message);


    }

    public String getMyMobileNumber(){
        SharedPreferences shared = context.getSharedPreferences("com.example.privateSettings", context.MODE_PRIVATE);
        String a = null;
        String mobile_number = shared.getString("myMobileNumber", a);
        return mobile_number;

    }


    @Override
    public void processIncomingMessage(MessageCard message) {
        App.getContactsRepo().update(message.getContactKey(),message);
    }

    @Override
    public void processIncomingMessage(MessageCmd message) {
        if(!Preferences.getRemoteCommand()) {
            Timber.e("remote commands are disabled");
            return;
        }


        if(!Preferences.getPubTopicCommands().equals(message.getTopic())) {
            Timber.e("cmd message received on wrong topic");
            return;
        }

        switch (message.getAction()) {
            case MessageCmd.ACTION_REPORT_LOCATION:
                System.out.println("ServiceMesssage <switch / case> ============================================================================================================");
                ServiceProxy.getServiceLocator().reportLocationResponse();
                break;
            case MessageCmd.ACTION_WAYPOINTS:
                ServiceProxy.getServiceLocator().publishWaypointsMessage();
                break;
            case MessageCmd.ACTION_SET_WAYPOINTS:
                MessageWaypoints w = message.getWaypoints();
                if(w != null)
                    Preferences.importWaypointsFromJson(w.getWaypoints());
                break;
            case MessageCmd.ACTION_SET_CONFIGURATION:
                Preferences.importFromMessage(message.getConfiguration());
                break;
            case MessageCmd.ACTION_REPORT_ADDRESS:
                break;
            case MessageCmd.ACTION_REPORT_GEOHASH:
                break;
            case MessageCmd.ACTION_RECONNECT:
                ServiceProxy.getServiceMessage().reconnect();
            case MessageCmd.ACTION_RESTART:
                Intent mStartActivity = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                mStartActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                int mPendingIntentId = 223344;
                PendingIntent mPendingIntent = PendingIntent.getActivity(context, mPendingIntentId, mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager mgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
                System.exit(0);
        }
    }

    @Override
    public void processIncomingMessage(MessageTransition message) {
        ServiceProxy.getServiceNotification().processMessage(message);
    }

}
