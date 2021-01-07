package com.example.prm391x_tourguide_ngoclptse00512x;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HotelAdapter extends BaseAdapter {
    private List<Contact> listHotelContact;
    private Activity activity;

    public HotelAdapter(List<Contact> listHotelContact, Activity activity) {
        this.listHotelContact = listHotelContact;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listHotelContact.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewIcon {
        TextView tvHotelName;
        TextView tvHotelAddress;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.fragment_hotel, viewGroup, false);
            ViewIcon icon = new ViewIcon();
            icon.tvHotelName = view.findViewById(R.id.tv_hotelName);
            icon.tvHotelAddress = view.findViewById(R.id.tv_hotelAddress);
            view.setTag(icon);
        }

        ViewIcon icon = (ViewIcon) view.getTag();
        Contact contact = listHotelContact.get(i);
        icon.tvHotelName.setText(contact.getName());
        icon.tvHotelAddress.setText((contact.getAddress()));

        return view;
    }
}
