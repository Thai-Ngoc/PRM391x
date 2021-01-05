package com.example.prm391x_tourguide_ngoclptse00512x;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BusAdapter extends BaseAdapter {

    private List<ContactBus> listBusContact;
    private Activity activity;

    public BusAdapter(List<ContactBus> listBusContact, Activity activity) {
        this.listBusContact = listBusContact;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listBusContact.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewIcon {
        TextView tv_busNo;
        TextView tv_busRoute;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.item_bus, viewGroup, false);
            ViewIcon icon = new ViewIcon();
            icon.tv_busNo = view.findViewById(R.id.tv_busNo);
            icon.tv_busRoute = view.findViewById(R.id.tv_busRoute);
            view.setTag(icon);
        }

        ViewIcon icon = (ViewIcon) view.getTag();
        ContactBus contactBus = listBusContact.get(i);

        icon.tv_busNo.setText(contactBus.getBusNo());
        icon.tv_busRoute.setText((contactBus.getBusRoute()));

        return view;
    }
}
