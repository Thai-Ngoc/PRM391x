package com.example.prm391x_shopmovies_ngoclptse00512x;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {  //extends RecyclerView.Adapter<Adapter.ItemViewHolder> {

    Context context;
    List<Model> listMovies;
    LayoutInflater inflater;

    public  Adapter(Context context, List<Model> arr){
        this.context = context;
        this.listMovies = arr;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listMovies.size();
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
        convertView = inflater.inflate(R.layout.item,null);
        ImageView img = convertView.findViewById(R.id.iv_image);
        TextView title = convertView.findViewById(R.id.tv_title);
        TextView price = convertView.findViewById(R.id.tv_price);
        Model movie = listMovies.get(position);
        Toast.makeText(context,movie.image_url,Toast.LENGTH_LONG).show();
        Picasso.with(context).load(movie.image_url).into(img);
        title.setText(movie.title);
        price.setText(movie.price);
        return convertView;
    }
    /*private List<Model> item;
    private Context context;

    public Adapter(List<Model> item, Context c) {
        this.item = item;
        this.context = c;
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Model m = item.get(position);
        Picasso.with(context)
                .load(m.image_url)
                .into(holder.ivImage);
        holder.tvTitle.setText(m.title);
        holder.tvPrice.setText(m.price);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvPrice;
        public ImageView ivImage;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPrice = itemView.findViewById(R.id.tv_price);
            ivImage = itemView.findViewById(R.id.iv_image);
        }
    }*/
}
