package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       if (intent.getAction().equals("android.intent.action.BATTERY.LOW")){
           Toast.makeText(context, "Battery low!!" , Toast.LENGTH_SHORT).show();
       }
       else if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")){
                   Toast.makeText(context, " POWER CONNECTED " , Toast.LENGTH_SHORT).show();

        }
    }
}