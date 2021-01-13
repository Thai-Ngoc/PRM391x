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

        //Event button
        btnHotel = findViewById(R.id.btn_hotel); //Hotel
        btnAtm = findViewById(R.id.btn_atm); //Atm
        btnHospital = findViewById(R.id.btn_hospital); //Hospital
        btnBus = findViewById(R.id.btn_bus); //Bus route

        btnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //interact with hotel's fragment
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("frg", 1);
                startActivity(intent);
            }
        });

        btnAtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //interact with atm's fragment
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("frg", 2);
                startActivity(intent);
            }
        });

        btnHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //interact with hospital's fragment
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("frg", 3);
                startActivity(intent);
            }
        });

        btnBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //interact with bus's fragment
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("frg", 4);
                startActivity(intent);
            }
        });
    }
}