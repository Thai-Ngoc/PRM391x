package com.example.prm391x_tourguide_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnHotel = findViewById(R.id.btn_hotel);
    Button btnAtm = findViewById(R.id.btn_atm);
    Button btnHospital = findViewById(R.id.btn_hospital);
    Button btnBus = findViewById(R.id.btn_bus);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



}