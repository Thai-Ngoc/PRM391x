package com.example.prm391x_alarmclock_ngoclptse00512x;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TimePickerActivity extends AppCompatActivity {
    private Button mBtnAdd, mBtnCancel;
    private TimePicker timePicker;

    AlarmDatabase alarmDatabase = new AlarmDatabase(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        //TimePicker
        timePicker = findViewById(R.id.timePicker);

        mBtnAdd = findViewById(R.id.addButton);
        mBtnCancel = findViewById(R.id.cancelButton);

        final Intent i = new Intent(this, MainActivity.class);

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                TimeModel timeModel = new TimeModel(hour, minute);
                alarmDatabase.addTime(timeModel);

                startActivity(i);
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}