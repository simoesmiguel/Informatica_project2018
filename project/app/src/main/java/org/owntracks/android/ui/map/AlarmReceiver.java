package org.owntracks.android.ui.map;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.owntracks.android.R;
import org.owntracks.android.activities.Notifications;
import org.owntracks.android.services.ServiceLocator;
import org.owntracks.android.services.ServiceProxy;
import android.content.SharedPreferences;


import java.util.HashSet;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.hasExtra("<CMIYC>GeoHashInformation") && intent.hasExtra("<CMIYC>messageId")) {
            //send message to broker
            System.out.println("<AlarmReceiver>  GeoHashInformation "+intent.getExtras().getString("<CMIYC>GeoHashInformation"));
            System.out.println("<AlarmReceiver>  messageID "+intent.getExtras().getString("<CMIYC>messageId"));

            PendingIntent p = ServiceProxy.getBroadcastIntentForService(context, ServiceProxy.SERVICE_LOCATOR, ServiceLocator.RECEIVER_ACTION_GEOHASH, intent.getExtras());
            try {
                p.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
        else if(intent.hasExtra("decodedAddress") && intent.hasExtra("user_id")){
            System.out.println("<AlarmReceiver> receiving address");
            System.out.println("<AlarmReceiver> decodedAddress: "+intent.getExtras().getString("decodedAddress"));
            String JSON = intent.getExtras().getString("decodedAddress");
            String address = null;

             try {
                JSONObject jo = new JSONObject(JSON);
                address = jo.getString("address");


                 NotificationCompat.Builder mBuilder =
                         (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                                 .setSmallIcon(R.drawable.cmiyc_icon_notif)
                                 .setContentTitle("CMIYC")
                                 .setContentText(new StringBuilder().append(intent.getExtras().getString("user_id")+" shared something with you!").toString())
                                 .setDefaults(Notification.DEFAULT_SOUND)
                                 .setDefaults(Notification.DEFAULT_VIBRATE)
                                 .setAutoCancel(true);

                 Intent notificationIntent = new Intent(context, Notifications.class);
                 notificationIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);


                 notificationIntent.putExtra("decodedMessage",address);
                 notificationIntent.putExtra("id",intent.getExtras().getString("user_id"));
                 PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                 mBuilder.setContentIntent(pendingIntent);

                 NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

                 // notificationId is a unique int for each notification that you must define
                 notificationManager.notify(Integer.parseInt( jo.getString("user_id")), mBuilder.build());


            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Toast.makeText(context,"decoded: "+intent.getExtras().getString("decodedAddress"),Toast.LENGTH_SHORT).show();


        }
        else if(intent.hasExtra("decodedMeetingPoint") && intent.hasExtra("user_id")){
            String JSON = intent.getExtras().getString("decodedMeetingPoint");
            String name,lat,lon,user_id = null;
            System.out.println("<ALARM RECEIVER> Receiving Decoded Meeting Point ");

            try {
                JSONObject jo = new JSONObject(JSON);
                name = jo.getString("name");
                lat= jo.getString("lat");
                lon= jo.getString("lon");
                user_id=intent.getExtras().getString("user_id");

                System.out.println("MeetingPoint DATA: \n name: "+name+"\n lat"+lat+"\n lon: "+lon+"\n user_name: "+user_id);


                NotificationCompat.Builder mBuilder =
                        (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                                .setSmallIcon(R.drawable.cmiyc_icon_notif)
                                .setContentTitle("CMIYC")
                                .setContentText(new StringBuilder().append(user_id).append(" shared a meetingPoint with you!").toString())
                                .setDefaults(Notification.DEFAULT_SOUND)
                                .setDefaults(Notification.DEFAULT_VIBRATE)
                                .setAutoCancel(true);


                //long time_notifcation= Calendar.getInstance().getTimeInMillis();

                //decode message
                //lm.recvAndDecipher(message);

                // Gets an instance of the NotificationManager service//

                Intent notificationIntent = new Intent(context, MapActivity.class);
                notificationIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);


                notificationIntent.putExtra("meetingPointName",name);
                notificationIntent.putExtra("meetingPointCoords",lat+","+lon);
                notificationIntent.putExtra("srcName",user_id);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(pendingIntent);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

                // notificationId is a unique int for each notification that you must define
                notificationManager.notify(Integer.parseInt(jo.getString("user_id")), mBuilder.build());


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        else if(intent.hasExtra("inGeohash")){
            boolean inGeohash = Boolean.parseBoolean(intent.getExtras().getString("inGeohash"));
            if(inGeohash){  // user is inside the geoHash of the other user
                String name = intent.getExtras().getString("user_id");
                // send notification to the user
                NotificationCompat.Builder mBuilder =
                        (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                                .setSmallIcon(R.drawable.cmiyc_icon_notif)
                                .setContentTitle("CMIYC")
                                .setContentText(new StringBuilder().append(name).append(" is close to you").toString())
                                .setDefaults(Notification.DEFAULT_SOUND)
                                .setDefaults(Notification.DEFAULT_VIBRATE)
                                .setAutoCancel(true);


                //long time_notifcation= Calendar.getInstance().getTimeInMillis();

                //decode message
                //lm.recvAndDecipher(message);

                // Gets an instance of the NotificationManager service//

                Intent notificationIntent = new Intent(context, Notifications.class);
                notificationIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);


                notificationIntent.putExtra("geoHash_message"," is close to you");
                notificationIntent.putExtra("geoHash_name",name);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(pendingIntent);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

                // notificationId is a unique int for each notification that you must define
                notificationManager.notify(001, mBuilder.build());
            }
        }
        else if(intent.hasExtra("myPhoneNumber")){
            System.out.println("<AlarmReceiver> MobileNumber received");
           /* if(!context.getSharedPreferences("com.example.privateSettings", context.MODE_PRIVATE).getString("myMobileNumber", new String()).equals("")
                    && context.getSharedPreferences("com.example.privateSettings", context.MODE_PRIVATE).getString("myMobileNumber", new String()) != null){
                // if mobile number is already saved on sharedPreferences, just do nothing
            }
            else {*/
                //save it on sharedPreferences
                SharedPreferences.Editor editor = context.getSharedPreferences("com.example.privateSettings", context.MODE_PRIVATE).edit();
                editor.putString("myMobileNumber", intent.getExtras().getString("myPhoneNumber"));
                editor.commit();
                System.out.println(" <AlarmReceiver> myPhoneNumber: "+intent.getExtras().getString("myPhoneNumber"));

//            }
        }
    }
}
