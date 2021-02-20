package com.example.prm391x_shopmovies_ngoclptse00512x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder> {

    private List<Model> item;
    private Context context;

    public Adapter(List<Model> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
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

    @Override
    public int getItemCount() {
        return item.size();
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
    }
}
