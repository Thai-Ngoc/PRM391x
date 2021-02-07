package com.example.prm391x_alarmclock_ngoclptse00512x;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class MyListAdapter extends ArrayAdapter<TimeModel> {

    private final Activity CONTEXT;
    private final ArrayList<TimeModel> TIMES_LIST;

    AlarmDatabase mAlarmDatabase;
    Calendar mCalendar;
    AlarmManager mAlarmManager;
    PendingIntent mPendingIntent;
    ArrayList<PendingIntent> mPendingList;

    public MyListAdapter(Activity context, ArrayList<TimeModel> timesList) {
        super(context, R.layout.mylist, timesList);
        // TODO Auto-generated constructor stub

        this.CONTEXT = context;
        this.TIMES_LIST = timesList;
        mAlarmDatabase = new AlarmDatabase(context);


    }

    public View getView(final int position,View view,ViewGroup parent) {
        LayoutInflater inflater=CONTEXT.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = rowView.findViewById(R.id.title);
        TextView subtitleText = rowView.findViewById(R.id.subtitle);
        ToggleButton toggleButton = rowView.findViewById(R.id.toggleButton);
        Button deleteButton = rowView.findViewById(R.id.deleteButton);


        titleText.setText(TIMES_LIST.get(position).toString());
        subtitleText.setText("Alarm Clock");

        mCalendar = Calendar.getInstance();
        mAlarmManager = (AlarmManager) CONTEXT.getSystemService(ALARM_SERVICE);
        mPendingList = new ArrayList<>();
        for (int i = 0; i < TIMES_LIST.size(); i++) {
            mPendingList.add(null);
        }

        final Intent alarmIntent = new Intent(CONTEXT, AlarmReceiver.class);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((ToggleButton) v).isChecked();
                if (checked){
                    // On alarm
                    Toast.makeText(CONTEXT, "You choose ON", Toast.LENGTH_SHORT).show();

                    mCalendar.set(Calendar.HOUR_OF_DAY, TIMES_LIST.get(position).getHour());
                    mCalendar.set(Calendar.MINUTE, TIMES_LIST.get(position).getMinute());

                    alarmIntent.putExtra("extra", "on");
                    mPendingIntent = PendingIntent.getBroadcast(
                            CONTEXT, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT
                    );

                    mPendingList.set(position, mPendingIntent);

                    mAlarmManager.set(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis(), mPendingList.get(position));
                }
                else{
                    // Off alarm

                    Toast.makeText(CONTEXT, "You choose OFF", Toast.LENGTH_SHORT).show();
                    mAlarmManager.cancel(mPendingIntent);
                    alarmIntent.putExtra("extra", "off");
                    CONTEXT.sendBroadcast(alarmIntent);
                    AlarmService.sMediaPlayer.stop();

                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            //delete alarm
            @Override
            public void onClick(View v) {
                mAlarmDatabase.deleteTime(TIMES_LIST.get(position));
                //remove from list
                TIMES_LIST.remove(position);
                CONTEXT.recreate();
            }
        });

        return rowView;

    };
}

