package com.example.prm391x_tourguide_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent(); //interact with MainActivity
        int frg = intent.getIntExtra("frg", 0);

        Fragment fragment = null;

        switch(frg) {
            case 1: //when user click button Khách sạn
                fragment = new HotelFragment();
                break;

            case 2: //when user click button ATM
                fragment = new AtmFragment();
                break;

            case 3: //when user click button Bệnh viện
                fragment = new HospitalFragment();
                break;

            case 4: //when user click button Xe bus
                fragment = new BusFragment();
                break;
        }

        fragment(fragment);
    }

    public void fragment (Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, fragment).commit();
    }
}