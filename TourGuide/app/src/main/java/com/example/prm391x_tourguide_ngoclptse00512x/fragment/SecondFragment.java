package com.example.prm391x_tourguide_ngoclptse00512x.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.prm391x_tourguide_ngoclptse00512x.R;
import com.example.prm391x_tourguide_ngoclptse00512x.adapter.ListAdapter;
import com.example.prm391x_tourguide_ngoclptse00512x.model.Contact;

import java.util.List;

public class SecondFragment extends Fragment {
    private ListAdapter listAdapter;
    private ListView listView;

    public SecondFragment() {
        super(R.layout.fragment_second);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        List<Contact> list = (List<Contact>) getArguments().get("list");

        listAdapter = new ListAdapter(getActivity(), list);
        listView.setAdapter(listAdapter);

    }

    private void initView(View view) {
        listView = view.findViewById(R.id.listView);
    }
}