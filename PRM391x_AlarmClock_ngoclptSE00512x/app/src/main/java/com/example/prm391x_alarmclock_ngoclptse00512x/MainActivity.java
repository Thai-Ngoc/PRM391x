package com.example.prm391x_alarmclock_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addAlarmBtn;
    ListView listView;

    private AlarmDatabase alarmDatabase = new AlarmDatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAlarmBtn = findViewById(R.id.addAlarmButton);
        listView = findViewById(R.id.listAlarm);

        // Read all alarms stored in database
        ArrayList<TimeModel> timeList = new ArrayList<>(alarmDatabase.getAllTimes());

        // add to ListView
        MyListAdapter adapter = new MyListAdapter(this, timeList);
        listView.setAdapter(adapter);

        final Intent i = new Intent(this, TimePickerActivity.class);
        addAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
}