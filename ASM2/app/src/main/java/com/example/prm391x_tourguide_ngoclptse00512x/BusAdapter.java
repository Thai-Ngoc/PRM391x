package com.example.prm391x_tourguide_ngoclptse00512x;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BusAdapter extends BaseAdapter {
    private List<Contact> listBusContact;
    private Activity activity;

    public BusAdapter(List<Contact> listBusContact, Activity activity) {
        this.listBusContact = listBusContact;
        this.activity = activity;
    }

    public int getCount() {
        return listBusContact.size();
    }


    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    static class ViewIcon {
        TextView tvBusName;
        TextView tvBusAddress;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.fragment_bus, viewGroup, false);
            ViewIcon icon = new ViewIcon();
            icon.tvBusName = view.findViewById(R.id.tv_busName);
            icon.tvBusAddress = view.findViewById(R.id.tv_busAddress);
            view.setTag(icon);
        }

        ViewIcon icon = (ViewIcon) view.getTag();
        Contact contact = listBusContact.get(i);
        icon.tvBusName.setText(contact.getName());
        icon.tvBusAddress.setText((contact.getAddress()));

        return view;
    }
}
