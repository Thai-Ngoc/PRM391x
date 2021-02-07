package com.example.prm391x_alarmclock_ngoclptse00512x;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class TimeModel implements Serializable {
    private int mId;
    private int mHour;
    private int mMinute;

    public TimeModel() {

    }

    public TimeModel(int hour, int minute) {
        this.mHour = hour;
        this.mMinute = minute;
    }

    public TimeModel(int id, int hour, int minute) {
        this.mId = id;
        this.mHour = hour;
        this.mMinute = minute;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getHour() {
        return mHour;
    }

    public void setHour(int hour) {
        this.mHour = hour;
    }

    public int getMinute() {
        return mMinute;
    }

    public void setMinute(int minute) {
        this.mMinute = minute;
    }

    @NonNull
    @Override
    public String toString() {
        return this.mHour + ":" + this.mMinute;
    }
}

