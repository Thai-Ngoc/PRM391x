package com.example.prm391x_tourguide_ngoclptse00512x;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.prm391x_tourguide_ngoclptse00512x.R.drawable.ic_launcher_background;

public class BusFragment<Contact> extends Fragment {
    private ListView busLvContent;
    private List<Contact> contactBusList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview, container, false);

        contactBusList.add((Contact) new ContactBus("Tuyến 01", "BX Gia Lâm - BX Yên Nghĩa"));
        contactBusList.add((Contact) new ContactBus("Tuyến 02", "Bác Cổ - BX Yên Nghĩa"));
        contactBusList.add((Contact) new ContactBus("Tuyến 03A", "BX Giáp Bát - BX Gia Lâm"));
        contactBusList.add((Contact) new ContactBus("Tuyến 03B", "BX Giáp Bát - Vincom- Phúc Lợi"));
        contactBusList.add((Contact) new ContactBus("Tuyến 04", "Long Biên - BX Nước Ngầm"));
        contactBusList.add((Contact) new ContactBus("Tuyến 05", "Linh Đàm - Phú Diễn"));
        contactBusList.add((Contact) new ContactBus("Tuyến 06", "BX Giáp Bát - Phú Minh(Phú Xuyên)"));
        contactBusList.add((Contact) new ContactBus("Tuyến 07", "Cầu Giấy - Nội Bài"));
        contactBusList.add((Contact) new ContactBus("Tuyến 08", "Long Biên - Đông Mỹ"));


        return view;
    }
}