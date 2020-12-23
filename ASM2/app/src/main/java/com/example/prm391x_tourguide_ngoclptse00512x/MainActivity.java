package com.example.prm391x_tourguide_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button hotel;
    Button atm;
    Button hospital;
    Button bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hotel = (Button)findViewById(R.id.hotel);
        atm = (Button)findViewById(R.id.atm);
        hospital = (Button)findViewById(R.id.hospital);
        bus = (Button)findViewById(R.id.bus);
    }


}