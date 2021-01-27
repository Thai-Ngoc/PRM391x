package com.example.prm391xlab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import java.util.Date;

public class BoundServiceActivity extends Activity {
    private MyBoundService myBoundService;

    private boolean mIsBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);

        Button btnShowCurrentDate = (Button) findViewById(R.id.btnShowCurrentDate);

    }
}