package com.example.prm391x_alarmclock_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mBtnAddAlarm;
    ListView mListView;

    private AlarmDatabase mAlarmDatabase = new AlarmDatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button creates a new alarm
        mBtnAddAlarm = findViewById(R.id.btn_addAlarm);

        //ListView displays list of alarm
        mListView = findViewById(R.id.lv_listAlarm);

        // Read all alarms stored in database
        ArrayList<TimeModel> timeList = new ArrayList<>(mAlarmDatabase.getAllTimes());

        // add to ListView
        MyListAdapter adapter = new MyListAdapter(this, timeList);
        mListView.setAdapter(adapter);

        final Intent i = new Intent(this, TimePickerActivity.class);
        mBtnAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
}