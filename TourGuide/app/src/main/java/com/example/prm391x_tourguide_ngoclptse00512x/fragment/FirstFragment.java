package com.example.prm391x_tourguide_ngoclptse00512x.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.prm391x_tourguide_ngoclptse00512x.R;
import com.example.prm391x_tourguide_ngoclptse00512x.model.Contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private Button mBtnHotel;
    private Button mBtnATM;
    private Button mBtnHospital;
    private Button mBtnBus;

    private SecondFragment mSecondFragment;
    private Bundle mBundle;

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        mSecondFragment = new SecondFragment();
        mBundle = new Bundle();

        //Click button Khách sạn to view list of hotels
        mBtnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> contacts = new ArrayList<>();

                contacts.add(new Contact(getString(R.string.hotel1), getString(R.string.hotelAdd1)));
                contacts.add(new Contact(getString(R.string.hotel2), getString(R.string.hotelAdd2)));
                contacts.add(new Contact(getString(R.string.hotel3), getString(R.string.hotelAdd3)));
                contacts.add(new Contact(getString(R.string.hotel4), getString(R.string.hotelAdd4)));
                contacts.add(new Contact(getString(R.string.hotel5), getString(R.string.hotelAdd5)));
                contacts.add(new Contact(getString(R.string.hotel6), getString(R.string.hotelAdd6)));
                contacts.add(new Contact(getString(R.string.hotel7), getString(R.string.hotelAdd7)));
                contacts.add(new Contact(getString(R.string.hotel8), getString(R.string.hotelAdd8)));
                contacts.add(new Contact(getString(R.string.hotel9), getString(R.string.hotelAdd9)));

                mBundle.putSerializable("list", (Serializable) contacts);
                mSecondFragment.setArguments(mBundle);
                navigate();
            }
        });

        //click button ATM to view list of ATMs
        mBtnATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> contacts = new ArrayList<>();
                contacts.add(new Contact(getString(R.string.atm1), getString(R.string.atmAdd1)));
                contacts.add(new Contact(getString(R.string.atm2), getString(R.string.atmAdd2)));
                contacts.add(new Contact(getString(R.string.atm3), getString(R.string.atmAdd3)));
                contacts.add(new Contact(getString(R.string.atm4), getString(R.string.atmAdd4)));
                contacts.add(new Contact(getString(R.string.atm5), getString(R.string.atmAdd5)));
                contacts.add(new Contact(getString(R.string.atm6), getString(R.string.atmAdd6)));
                contacts.add(new Contact(getString(R.string.atm7), getString(R.string.atmAdd7)));
                contacts.add(new Contact(getString(R.string.atm8), getString(R.string.atmAdd8)));
                contacts.add(new Contact(getString(R.string.atm9), getString(R.string.atmAdd9)));

                mBundle.putSerializable("list", (Serializable) contacts);
                mSecondFragment.setArguments(mBundle);
                navigate();
            }
        });

        //click button Bệnh viện to view list of hospitals
        mBtnHospital.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                List<Contact> contacts = new ArrayList<>();
                contacts.add(new Contact(getString(R.string.hos1), getString(R.string.hosAdd1)));
                contacts.add(new Contact(getString(R.string.hos2), getString(R.string.hosAdd2)));
                contacts.add(new Contact(getString(R.string.hos3), getString(R.string.hosAdd3)));
                contacts.add(new Contact(getString(R.string.hos4), getString(R.string.hosAdd4)));
                contacts.add(new Contact(getString(R.string.hos5), getString(R.string.hosAdd5)));
                contacts.add(new Contact(getString(R.string.hos6), getString(R.string.hosAdd6)));
                contacts.add(new Contact(getString(R.string.hos7), getString(R.string.hosAdd7)));
                contacts.add(new Contact(getString(R.string.hos8), getString(R.string.hosAdd8)));
                contacts.add(new Contact(getString(R.string.hos9), getString(R.string.hosAdd9)));
                contacts.add(new Contact(getString(R.string.hos10), getString(R.string.hosAdd10)));

                mBundle.putSerializable("list", (Serializable) contacts);
                mSecondFragment.setArguments(mBundle);
                navigate();
            }
        });

        //click button Xe bus to view list of buses
        mBtnBus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                List<Contact> contacts = new ArrayList<>();
                contacts.add(new Contact(getString(R.string.bus1), getString(R.string.busRoute1)));
                contacts.add(new Contact(getString(R.string.bus2), getString(R.string.busRoute2)));
                contacts.add(new Contact(getString(R.string.bus3a), getString(R.string.busRoute3a)));
                contacts.add(new Contact(getString(R.string.bus3b), getString(R.string.busRoute3b)));
                contacts.add(new Contact(getString(R.string.bus4), getString(R.string.busRoute4)));
                contacts.add(new Contact(getString(R.string.bus5), getString(R.string.busRoute5)));
                contacts.add(new Contact(getString(R.string.bus6), getString(R.string.busRoute6)));
                contacts.add(new Contact(getString(R.string.bus7), getString(R.string.busRoute7)));
                contacts.add(new Contact(getString(R.string.bus8), getString(R.string.busRoute8)));

                //packed and send data to second fragment
                mBundle.putSerializable("list", (Serializable) contacts);
                mSecondFragment.setArguments(mBundle);

                navigate();
            }
        });
    }

    //navigate to second fragment
    private void navigate() {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.rootView, mSecondFragment)
                .commit();
    }

    //mapping buttons
    private void initView(View view) {
        mBtnHotel = view.findViewById(R.id.btn_hotel);
        mBtnATM = view.findViewById(R.id.btn_atm);
        mBtnHospital = view.findViewById(R.id.btn_hospital);
        mBtnBus = view.findViewById(R.id.btn_bus);
    }
}