package com.example.prm391x_shopmovies_ngoclptse00512x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent;
        // Open MovieActivity if user has been logged in, else open LoginActivity
        if (isLoggedIn()) {
            intent = new Intent(MainActivity.this, MoviesActivity.class);
        } else {
            intent = new Intent(MainActivity.this, LoginActivity.class);
        }
        //intent = new Intent(MainActivity.this, MoviesActivity.class);
        startActivity(intent);
    }

    /** Check if the app has been logged before */
    private boolean isLoggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE.txt", MODE_PRIVATE);
        return sharedPreferences.getBoolean("LOGGED_IN", false);
    }
}