package com.example.prm391x_tourguide_ngoclptse00512x;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AtmFragment extends Fragment {
    private ListView lvContent;
    private List<Contact> contactList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview, container, false);

        contactList.add(new Contact("ATM Hoàn Kiếm", "17 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội"));
        contactList.add(new Contact("ATM Đinh Tiên Hoàng", "7 Đinh Tiên Hoàng, Quận Hoàn Kiếm, Hà Nội"));
        contactList.add(new Contact("ATM Hội sở", "57 Lý Thường Kiệt, Quận Hoàn Kiếm, Hà Nộim"));
        contactList.add(new Contact("ATM Nam Hà Nội", "236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội"));
        contactList.add(new Contact("ATM Hai Bà Trưng", "300-302 Trần Khát Chân, Quận Hai Bà Trưng, Hà Nội"));
        contactList.add(new Contact("ATM Lê Ngọc Hân", "44 Lê Ngọc Hân, Quận Hai Bà Trưng, Hà Nội"));
        contactList.add(new Contact("ATM Thăng Long", "129-131 Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội"));
        contactList.add(new Contact("ATM Phạm Hùng", "Tòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội"));
        contactList.add(new Contact("ATM Khâm Thiên", "158 Khâm Thiên, Quận Đống Đa, Hà Nội"));

        AtmAdapter atmAdapter = new AtmAdapter(contactList, getActivity());
        lvContent = view.findViewById(R.id.list_item);
        lvContent.setAdapter(atmAdapter);
        return view;
    }
}