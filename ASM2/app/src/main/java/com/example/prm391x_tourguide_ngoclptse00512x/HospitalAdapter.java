package com.example.prm391x_tourguide_ngoclptse00512x;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HospitalAdapter extends BaseAdapter {
    private List<Contact> listHosContact;
    private Activity activity;

    public HospitalAdapter(List<Contact> listHosContact, Activity activity) {
        this.listHosContact = listHosContact;
        this.activity = activity;
    }

    public int getCount() {
        return listHosContact.size();
    }


    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    static class ViewIcon {
        TextView tvHosName;
        TextView tvHosAddress;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.fragment_hospital, viewGroup, false);
            ViewIcon icon = new ViewIcon();
            icon.tvHosName = view.findViewById(R.id.tv_hosName);
            icon.tvHosAddress = view.findViewById(R.id.tv_hosAddress);
            view.setTag(icon);
        }

        ViewIcon icon = (ViewIcon) view.getTag();
        Contact contact = listHosContact.get(i);
        icon.tvHosName.setText(contact.getName());
        icon.tvHosAddress.setText((contact.getAddress()));

        return view;
    }
}
