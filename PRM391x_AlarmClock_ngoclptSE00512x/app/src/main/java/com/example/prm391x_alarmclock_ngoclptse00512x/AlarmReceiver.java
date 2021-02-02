package com.example.prm391x_alarmclock_ngoclptse00512x;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("AlarmReceiver", "AlarmReceiver has been called.");
        String extra = intent.getExtras().getString("extra");
        Intent receiverIntent = new Intent(context, AlarmService.class);
        //send data to AlarmService
        receiverIntent.putExtra("extra", extra);
        //alarm ring
        context.startService(receiverIntent);
    }
}

