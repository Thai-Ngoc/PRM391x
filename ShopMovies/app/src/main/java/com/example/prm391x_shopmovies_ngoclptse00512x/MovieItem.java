package com.example.prm391x_shopmovies_ngoclptse00512x;

public class MovieItem {
    private String mImageLink;   // Movie poster link
    private String mTitle;   // Movie title
    private String mPrice;   // Movie price

    public MovieItem(String mImageLink, String mTitle, String mPrice) {
        this.mImageLink = mImageLink;
        this.mTitle = mTitle;
        this.mPrice = mPrice;
    }

    public String getmImageLink() {
        return mImageLink;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmPrice() {
        return mPrice;
    }
}
