package com.keshav.networkchangereceiverexample.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.keshav.networkchangereceiverexample.database.DatabaseClient;
import com.keshav.networkchangereceiverexample.database.LocationPoint;



public class NetworkChangeReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(final Context context, Intent intent)
    {
        try
        {
            /*if (isOnline(context)) {
                dialog(true);
                Log.e("keshav", "Online Connect Intenet ");

                final LocationPoint locationPoint = new LocationPoint();
                locationPoint.setLocation("online");

                //adding to database
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DatabaseClient.getInstance(context.getApplicationContext()).getAppDatabase()
                                .locationDao()
                                .insert(locationPoint);
                    }
                }).start();

            } else {
                dialog(false);
                Log.e("keshav", "Conectivity Failure !!! ");
                //adding to database

                final LocationPoint locationPoint = new LocationPoint();
                locationPoint.setLocation("offline");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DatabaseClient.getInstance(context.getApplicationContext()).getAppDatabase()
                                .locationDao()
                                .insert(locationPoint);
                    }
                }).start();
            }*/
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}