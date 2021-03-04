package com.example.prm391x_shopmovies_ngoclptse00512x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<MovieItem> listMovieItems;    // List of MovieItem objects
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<MovieItem> listMovieItems) {
        this.context = context;
        this.listMovieItems = listMovieItems;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listMovieItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_grid, null);

        // Movie poster
        ImageView imageView = convertView.findViewById(R.id.img_movie_poster);
        // Movie title
        TextView txtTitle = convertView.findViewById(R.id.txt_movie_title);
        // Movie price
        TextView txtPrice = convertView.findViewById(R.id.txt_movie_price);

        // Set movie info from MovieItem object
        MovieItem movieItem = listMovieItems.get(position);
        Picasso.get().load(movieItem.getImageLink()).into(imageView);   // Load image from URL
        txtTitle.setText(movieItem.getTitle());
        txtPrice.setText(movieItem.getPrice());

        return convertView;
    }

}
