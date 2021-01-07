package com.example.prm391x_tourguide_ngoclptse00512x;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class AtmAdapter extends BaseAdapter {
    private List<Contact> listAtmContact;
    private Activity activity;

    public AtmAdapter(List<Contact> listAtmContact, Activity activity) {
        this.listAtmContact = listAtmContact;
        this.activity = activity;
    }

    public int getCount() {
        return listAtmContact.size();
    }


    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    static class ViewIcon {
        TextView tvAtmName;
        TextView tvAtmAddress;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.fragment_atm, viewGroup, false);
            ViewIcon icon = new ViewIcon();
            icon.tvAtmName = view.findViewById(R.id.tv_atmName);
            icon.tvAtmAddress = view.findViewById(R.id.tv_atmAddress);
            view.setTag(icon);
        }

        ViewIcon icon = (ViewIcon) view.getTag();
        Contact contact = listAtmContact.get(i);
        icon.tvAtmName.setText(contact.getName());
        icon.tvAtmAddress.setText((contact.getAddress()));

        return view;
    }
}
