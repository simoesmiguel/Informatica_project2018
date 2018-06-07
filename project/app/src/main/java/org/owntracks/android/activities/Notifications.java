package org.owntracks.android.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.owntracks.android.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Notifications extends AppCompatActivity {


    private ListView newNotificationsListView;
    private ListView seenNotificationsListView;
    private ArrayAdapter<String> adapter;
    private String decodedMessage;
    private String id;
    private ArrayList<String> new_notifications;
    private ArrayList<String> seen_notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        new_notifications = new ArrayList<>();
        seen_notifications = new ArrayList<>();
        Intent intent = getIntent();

        if(intent.hasExtra("decodedMessage")&& intent.hasExtra("id")){  // it's going to enter inside this if when it comes from AlarmReceiver with decodedMessage as extra
            Bundle extras = getIntent().getExtras();
            id = extras.getString("id");
            decodedMessage = extras.getString("decodedMessage");

        }else if(intent.hasExtra("geoHash_message") && intent.hasExtra("geoHash_name")){  // it's going to enter inside this if when it comes from AlarmReceiver with geoHash as extra
            // Do something else
            Bundle extras = getIntent().getExtras();
            id = extras.getString("geoHash_name");
            decodedMessage = extras.getString("geoHash_message");

        }
        newNotificationsListView = (ListView) findViewById(R.id.newNotificationsListView);
        seenNotificationsListView = (ListView) findViewById(R.id.SeenNotificationsListView);
        setList_viewNewNotifications(false);
        setList_viewSeenNotifications("");




    }

    private void setList_viewSeenNotifications(String seenNotification) {
        if(!getSharedPreferences("com.example.seenNotifications",MODE_PRIVATE).getStringSet("seenNotificationSet", new HashSet<String>()).isEmpty()) {
            System.out.println("<seenNotifications> NOT NULL");

            //read from sharedPreferences
            SharedPreferences shared = getSharedPreferences("com.example.seenNotifications",MODE_PRIVATE);
            Set<String> set = shared.getStringSet("seenNotificationSet", new HashSet<String>());

            if(!seenNotification.equals("")&& id!=null && decodedMessage!=null) {
                //save to sharedPreferences
                SharedPreferences.Editor editor = getSharedPreferences("com.example.seenNotifications", MODE_PRIVATE).edit();
                set.add(seenNotification);
                editor.putStringSet("seenNotificationSet", set);
                editor.commit();
            }
            seen_notifications = new ArrayList<>(set);

        }else{
            System.out.println("<seenNotifications> IS NULL");
            if(!seenNotification.equals("") && id!=null && decodedMessage!=null){
                //save to sharedPreferences
                SharedPreferences.Editor editor = getSharedPreferences("com.example.seenNotifications", MODE_PRIVATE).edit();
                seen_notifications.add(seenNotification);
                editor.putStringSet("seenNotificationSet", new HashSet<String>(seen_notifications));
                editor.commit();
            }
        }

        adapter = new ArrayAdapter<String>(this, R.layout.list_item,seen_notifications );
        seenNotificationsListView.setAdapter(adapter);

        // ListView on item selected listener.
        final ArrayList<String> finalSeen_notifications = seen_notifications;
        seenNotificationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // TODO Auto-generated method stub
                showNotification(finalSeen_notifications.get(position),false);
            }
        });

    }

    private void setList_viewNewNotifications(boolean removed_notification) {

        if(removed_notification == false) {
            if (!getSharedPreferences("com.example.newNotifications", MODE_PRIVATE).getStringSet("newNotificationSet", new HashSet<String>()).isEmpty()) {
                System.out.println("<Notifications> NOT NULL");

                //read from sharedPreferences
                SharedPreferences shared = getSharedPreferences("com.example.newNotifications", MODE_PRIVATE);
                Set<String> set = shared.getStringSet("newNotificationSet", new HashSet<String>());

                if(id!=null && decodedMessage!=null) {
                    //save to sharedPreferences
                    SharedPreferences.Editor editor = getSharedPreferences("com.example.newNotifications", MODE_PRIVATE).edit();
                    set.add(id + " is at " + decodedMessage);
                    editor.putStringSet("newNotificationSet", set);
                    editor.commit();
                }
                new_notifications = new ArrayList<>(set);

            } else {
                System.out.println("<Notifications> IS NULL");

                if(id!=null && decodedMessage!=null) {
                    //save to sharedPreferences
                    SharedPreferences.Editor editor = getSharedPreferences("com.example.newNotifications", MODE_PRIVATE).edit();
                    new_notifications.add(id + " is at " + decodedMessage);
                    editor.putStringSet("newNotificationSet", new HashSet<String>(new_notifications));
                    editor.commit();
                }
            }
        }

        //set the listView with new_notifications array
        adapter = new ArrayAdapter<String>(this, R.layout.list_item,new_notifications );
        newNotificationsListView.setAdapter(adapter);

        // ListView on item selected listener.
        final ArrayList<String> finalNew_notifications = new_notifications;
        newNotificationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // TODO Auto-generated method stub
                System.out.println("<< Final New Notifications >> "+finalNew_notifications.get(position));
                showNotification(finalNew_notifications.get(position),true);
            }
        });

    }

    public void showNotification(final String notification, final Boolean newNotification){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Notification");
        builder.setMessage(notification);
        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(newNotification){

                    // remove the seen notification from com.example.newNotifications
                        //read from sharedPreferences
                        SharedPreferences shared = getSharedPreferences("com.example.newNotifications",MODE_PRIVATE);
                        Set<String> set = shared.getStringSet("newNotificationSet", new HashSet<String>());

                        //save to sharedPreferences
                        SharedPreferences.Editor editor = getSharedPreferences("com.example.newNotifications", MODE_PRIVATE).edit();
                        set.remove(notification);
                        editor.putStringSet("newNotificationSet",set);
                        editor.commit();
                        new_notifications = new ArrayList<>(set);

                   // add the seen notification to com.example.seenNotifications
                    setList_viewNewNotifications(true);
                    setList_viewSeenNotifications(notification);


                }
            }
        });
        builder.show();
    }


}
