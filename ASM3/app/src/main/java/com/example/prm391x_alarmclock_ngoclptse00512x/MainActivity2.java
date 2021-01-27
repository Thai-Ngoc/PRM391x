package com.example.prm391x_alarmclock_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity2 extends Activity {
    AlarmManager mAlarmManager;
    private PendingIntent mPendingIntent;
    private TimePicker mAlarmTimePicker;
    private TextView mAlarmTextView;
    private ToggleButton mAlarmToggle;
    private Calendar mCalendar;

    //Set an alarm
    private Button mBtnSetAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAlarmTimePicker = findViewById(R.id.timePicker);
        mAlarmTextView = findViewById(R.id.alarmText);
        mAlarmToggle = findViewById(R.id.alarmToggle);
        mCalendar = Calendar.getInstance();

        mAlarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(MainActivity2.this, AlarmReceiver.class);

        //mapping
        mBtnSetAlarm = findViewById(R.id.btn_setAlarm);

        mBtnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });

        mAlarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    mCalendar.set(Calendar.HOUR_OF_DAY,mAlarmTimePicker.getCurrentHour());
                    mCalendar.set(Calendar.MINUTE,mAlarmTimePicker.getCurrentMinute());

                    int hour = mAlarmTimePicker.getCurrentHour();
                    int minute = mAlarmTimePicker.getCurrentMinute();

                    String string_hour = String.valueOf(hour);
                    String string_minute = String.valueOf(minute);

                    if(minute < 10) {
                        string_minute = "0" + minute;
                    }

                    intent.putExtra("extra","on");

                    mPendingIntent = PendingIntent.getBroadcast(MainActivity2.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                    mAlarmManager.set(AlarmManager.RTC_WAKEUP,mCalendar.getTimeInMillis(),mPendingIntent);

                    mAlarmTextView.setText("On alarm at: " + string_hour + ":" + string_minute);
                } else {
                    mAlarmTextView.setText("Off alarm");
                    mAlarmManager.cancel(mPendingIntent);
                    intent.putExtra("extra","off");
                    sendBroadcast(intent);
                }
            }
        });
    }
}