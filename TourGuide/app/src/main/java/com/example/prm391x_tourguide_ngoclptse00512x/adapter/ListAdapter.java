package com.example.prm391x_tourguide_ngoclptse00512x.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.prm391x_tourguide_ngoclptse00512x.R;
import com.example.prm391x_tourguide_ngoclptse00512x.model.Contact;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Contact> list;
    private TextView tvName;
    private TextView tvAddress;

    public ListAdapter(Activity activity, List<Contact> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_list, parent, false);
        initView(view);

        tvName.setText(list.get(position).getName());
        tvAddress.setText(list.get(position).getAddress());

        return view;
    }

    private void initView(View view) {
        tvName = view.findViewById(R.id.tv_Name);
        tvAddress = view.findViewById(R.id.tv_Address);
    }

}
