package com.example.prm391x_tourguide_ngoclptse00512x;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BusFragment extends Fragment {
    private ListView lvContent;
    private List<Contact> contactList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview, container, false);

        contactList.add(new Contact("Tuyến 01", "BX Gia Lâm - BX Yên Nghĩa"));
        contactList.add(new Contact("Tuyến 02", "Bác Cổ - BX Yên Nghĩa"));
        contactList.add(new Contact("Tuyến 03A", "BX Giáp Bát - BX Gia Lâm"));
        contactList.add(new Contact("Tuyến 03B", "BX Giáp Bát - Vincom- Phúc Lợi"));
        contactList.add(new Contact("Tuyến 04", "Long biên - BX Nước Ngầm"));
        contactList.add(new Contact("Tuyến 05", "Linh Đàm - Phú Diễn"));
        contactList.add(new Contact("Tuyến 06", "BX Giáp Bát - Phú Minh(Phú Xuyên)"));
        contactList.add(new Contact("Tuyến 07", "Cầu Giấy - Nội Bài"));
        contactList.add(new Contact("Tuyến 08", "Long Biên - Đông Mỹ"));

        BusAdapter busAdapter = new BusAdapter(contactList, getActivity());
        lvContent = view.findViewById(R.id.list_item);
        lvContent.setAdapter(busAdapter);
        return view;
    }
}