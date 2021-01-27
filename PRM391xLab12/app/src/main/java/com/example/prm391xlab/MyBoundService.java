package com.example.prm391xlab;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;
public class MyBoundService extends Service {
    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
