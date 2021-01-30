package com.example.prm391x_alarmclock_ngoclptse00512x;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TimePickerActivity extends AppCompatActivity {
    Button addBtn, cancelBtn;
    TimePicker timePicker;

    AlarmDatabase alarmDatabase = new AlarmDatabase(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        //Phan TimePicker
        timePicker = findViewById(R.id.timePicker);

        addBtn = findViewById(R.id.addButton);
        cancelBtn = findViewById(R.id.cancelButton);

        final Intent i = new Intent(this, MainActivity.class);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                TimeModel timeModel = new TimeModel(hour, minute);
                alarmDatabase.addTime(timeModel);

                startActivity(i);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}