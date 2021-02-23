package com.example.prm391x_shopmovies_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize RecyclerView
        final RecyclerView rvMovies = findViewById(R.id.rv_movies);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        //Initialize OkHttpClient to get data
        OkHttpClient client = new OkHttpClient();

        //Initialize Moshi adapter to transform json to Model
        Moshi moshi = new Moshi.Builder().build();
        Type modelType = Types.newParameterizedType(List.class, Model.class);
        final JsonAdapter<List<Model>> jsonAdapter = moshi.adapter(modelType);

        //Create request to server
        Request request = new Request.Builder()
                .url("https://api.androidhive.info/json/movies_2017.json")
                .build();

        //Perform request
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //Get data returned from Json
                String json = response.body().string();
                final List<Model> movies = jsonAdapter.fromJson(json);

                //Display on RecyclerView
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvMovies.setAdapter(new Adapter(movies, MainActivity.this));
                    }
                });
            }
        });
    }
}