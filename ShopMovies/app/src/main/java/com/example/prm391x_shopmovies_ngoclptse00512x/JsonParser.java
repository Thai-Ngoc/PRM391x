package com.example.prm391x_shopmovies_ngoclptse00512x;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class JsonParser extends AsyncTask<String, String, Void> {
    ArrayList<MovieItem> mListMovieItems = new ArrayList<>();    // List of MovieItem objects
    BufferedInputStream mInputStream;
    JSONArray mJsonArray;
    String mResult = ""; // Result reading inputStream
    Activity mActivity;
    Context mContext;
    private int mPreviousPosition;  // Position of the previously clicked item in the GridView (Movies List)
    private View mPreviousView; // The View (movie) previously clicked


    public JsonParser(Activity activity, Context context) {
        this.mActivity = activity;
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... strings) {
        HttpsURLConnection httpsURLConnection = null;
        try {
            // Get URL address of JSON file
            URL url = new URL(Url.FETCH_DATA);
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            mInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
            mResult = readStream();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        try {
            mJsonArray = new JSONArray(mResult);
            if(mJsonArray != null) {
                // Create MovieItem objects using info from JSON data
                // Add objects into list
                for(int i = 0; i < mJsonArray.length(); i++) {
                    MovieItem movieItem = new MovieItem(
                            mJsonArray.getJSONObject(i).getString("image"),
                            mJsonArray.getJSONObject(i).getString("title"),
                            mJsonArray.getJSONObject(i).getString("price"));
                    mListMovieItems.add(movieItem);
                    Log.d("movieItem", movieItem.getImageLink() + movieItem.getTitle() + movieItem.getPrice());
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Set adapter to GridView
        GridView gridView = mActivity.findViewById(R.id.grid_view_movies);
        CustomAdapter adapter = new CustomAdapter(mContext, mListMovieItems);
        gridView.setAdapter(adapter);

        // Set Click Event for each GridView item
        // Show/ hide ShareButton on click if account is Facebook
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get account info
                SharedPreferences sharedPreferences = mContext.getSharedPreferences("USER_FILE.txt", mContext.MODE_PRIVATE);
                String account = sharedPreferences.getString("ACCOUNT", null);

                // Check if account is Facebook -> set up show/ hide on click
                if(account != null && account.equals("facebook")) {
                    ShareButton btnVisible, btnHide;    // Button will show on click, Button will hide on click (previous button)
                    btnVisible = view.findViewById(R.id.btn_share_images);
                    btnVisible.setVisibility(View.VISIBLE); // Show button being clicked
                    // Assign value for the first click
                    if (mPreviousView == null) {
                        mPreviousView = view;
                    }
                    // Check if the position clicked has changed -> hide old position
                    if (mPreviousPosition != position) {
                        if (mPreviousView != null) {
                            btnHide = mPreviousView.findViewById(R.id.btn_share_images);
                            btnHide.setVisibility(View.GONE);   // Hide button not being clicked (which was visible before)
                        }
                    }
                    mPreviousView = view;   // Update new previously clicked item view
                    mPreviousPosition = position; // Update new previously clicked item position

                    // Set up ShareButton to share image from ImageView to Facebook
                    ImageView imageView = view.findViewById(R.id.img_movie_poster);
                    imageView.setDrawingCacheEnabled(true);
                    Bitmap bitmap = imageView.getDrawingCache();
                    SharePhoto photo = new SharePhoto.Builder()
                            .setBitmap(bitmap)
                            .build();
                    SharePhotoContent content = new SharePhotoContent.Builder()
                            .addPhoto(photo)
                            .build();
                    btnVisible.setShareContent(content);
                }
            }
        });
    }

    private String readStream() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(mInputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
