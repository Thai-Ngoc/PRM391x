package com.example.prm391x_tourguide_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnHotel;
    Button btnAtm;
    Button btnHospital;
    Button btnBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHotel = findViewById(R.id.btn_hotel);
        btnAtm = findViewById(R.id.btn_atm);
        btnHospital = findViewById(R.id.btn_hospital);
        btnBus = findViewById(R.id.btn_bus);

        btnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

    }



}