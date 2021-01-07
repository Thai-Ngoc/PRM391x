package com.example.prm391x_tourguide_ngoclptse00512x;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HotelFragment extends Fragment {

    private ListView lvContent;
    private List<Contact> contactList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview, container, false);

        contactList.add(new Contact("The Queen Hotel & Spa", "67 Thuốc Bắc, Hàng Bồ, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam"));
        contactList.add(new Contact("Hanoi Nostalgia Hotel & Spa", "13-15 Lương Ngọc Quyến, Hàng Buồm, Quận Hoàn Kiếm, Hà Nội, Việt Nam"));
        contactList.add(new Contact("Church Legend Hotel Hanoi", "46 Ấu Triệu, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam"));
        contactList.add(new Contact("Little Hanoi Diamond Hotel", "11 Bát Đàn, Quận Hoàn Kiếm, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam"));
        contactList.add(new Contact("Flamingo Dai Lai Resort", "Thôn Ngọc Quang, Xã Ngọc Thanh, Vĩnh Phúc, Phúc Yên, Hà Nội, Việt Nam"));
        contactList.add(new Contact("Annam Legend Hotel", "27 Hàng Bè, Hàng Bạc, Quận Hoàn Kiếm, Hà Nội, Việt Nam"));
        contactList.add(new Contact("Hanoi Zesty Hotel", "20 Hàng Cân, Hàng Đào, Quận Hoàn Kiếm, Hà Nội, Việt Nam"));
        contactList.add(new Contact("Bluebell Hotel", "41 Ngõ Huyện, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam"));

        HotelAdapter hotelAdapter = new HotelAdapter(contactList, getActivity());
        lvContent = view.findViewById(R.id.list_item);
        lvContent.setAdapter(hotelAdapter);
        return view;
    }
}