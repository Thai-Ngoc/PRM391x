package com.example.prm391x_tourguide_ngoclptse00512x;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HospitalFragment extends Fragment {
    private ListView lvContent;
    private List<Contact> contactList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview, container, false);

        contactList.add(new Contact("Bệnh viện Bạch Mai", "78 – Đường Giải Phóng – Phương Mai – Đống Đa – Hà Nội"));
        contactList.add(new Contact("Bệnh viện Hữu Nghị", "Số 1 – Trần Khánh Dư – Quận Hai Bà Trưng – Hà Nội"));
        contactList.add(new Contact("Bệnh viện E, Hà Nội", "89 – Trần Cung – Nghĩa Tân – Cầu Giấy – Hà Nội"));
        contactList.add(new Contact("Viện Răng Hàm Mặt", "40B – Tràng Thi – Hoàn Kiếm – Hà Nội"));
        contactList.add(new Contact("Bệnh viện Tai Mũi Họng Trung Ương", "78 – Đường Giải Phóng – Quận Đống Đa – Hà Nội"));
        contactList.add(new Contact("Bệnh viện Mắt Trung Ương", "85 – Phố Bà Triệu – Quận Hai Bà Trưng – Hà Nội"));
        contactList.add(new Contact("Viện Y Học Cổ Truyền Trung Ương", "29 – Phố Nguyễn Bỉnh Khiêm – Quận Hai Bà Trưng – Hà Nội"));
        contactList.add(new Contact("Bệnh viện Nội Tiết", "80 – Thái Thịnh II – Thịnh Quang – Đống Đa – Hà Nội"));
        contactList.add(new Contact("Bệnh viện Việt Đức", "8 – Phố Phủ Doãn – Quận Hoàn Kiếm – Hà Nội"));
        contactList.add(new Contact("Bệnh viện Nhi Trung Ương", "18/879 – Đường La Thành – Quận Đống Đa – Hà Nội"));

        HospitalAdapter hosAdapter = new HospitalAdapter(contactList, getActivity());
        lvContent = view.findViewById(R.id.list_item);
        lvContent.setAdapter(hosAdapter);
        return view;
    }
}
