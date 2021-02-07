package com.example.prm391x_alarmclock_ngoclptse00512x;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class AlarmService extends Service {
    public static MediaPlayer sMediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("AlarmService", "Service has been called.");

        //receive data from AlarmReceiver
        String extra = intent.getExtras().getString("extra");
        sMediaPlayer = MediaPlayer.create(this, R.raw.ring);
        if (extra.equals("on")) {
            sMediaPlayer.start();
        } else if (extra.equals("off")) {
            sMediaPlayer.stop();
            sMediaPlayer.reset();
        }

        return START_NOT_STICKY;
    }
}

