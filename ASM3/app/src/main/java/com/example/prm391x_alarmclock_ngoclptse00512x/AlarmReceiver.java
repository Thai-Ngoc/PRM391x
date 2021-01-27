package com.example.prm391x_alarmclock_ngoclptse00512x;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Tôi trong Receiver","Xin chào");
        Intent myIntent = new Intent(context,Music.class);
        context.startService(myIntent);
    }
}
