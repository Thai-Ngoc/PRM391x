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
    private ListAdapter mListAdapter;
    private ListView mListView;

    public SecondFragment() {
        super(R.layout.fragment_second);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

        //received data from first fragment
        List<Contact> list = (List<Contact>) getArguments().get("list");

        mListAdapter = new ListAdapter(getActivity(), list);
        mListView.setAdapter(mListAdapter);

    }

    private void initView(View view) {
        mListView = view.findViewById(R.id.listView);
    }
}