package com.example.prm391x_shopmovies_ngoclptse00512x;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MoviesActivity extends AppCompatActivity {

    private JsonParser mJsonParser;
    int myLastVisiblePos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        // Run ASyncTask to get info from JSON file and display movies list
        try {
            mJsonParser = (JsonParser) new JsonParser(this, this).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Setup click event listener of BottomNavigation Bar
        // Switch to ProfileActivity if profile icon is clicked
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.navigation_profile) {
                    Intent intent = new Intent(MoviesActivity.this, ProfileActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Setup scroll event listener of the GridView (movie list)
        // Show/Hide (animated) BottomNavigation Bar if scrolling Down/Up
        GridView gridView = findViewById(R.id.grid_view_movies);
        myLastVisiblePos = gridView.getFirstVisiblePosition();
        gridView.setOnScrollListener( new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int currentFirstVisPos = view.getFirstVisiblePosition();
                // If scroll down
                if(currentFirstVisPos > myLastVisiblePos) {
                    showBottomNav(bottomNavigationView);
                }
                // If scroll up
                if(currentFirstVisPos < myLastVisiblePos) {
                    hideBottomNav(bottomNavigationView);
                }
                myLastVisiblePos = currentFirstVisPos;
            }
        });
    }

    /** Animate to show BottomNavigation Bar **/
    private void showBottomNav(BottomNavigationView view) {
        view.setVisibility(View.VISIBLE);
        view.animate().translationY(0);
    }

    /** Animate to hide BottomNavigation Bar **/
    private void hideBottomNav(BottomNavigationView view) {
        view.animate().translationY(view.getHeight());
    }

    /** Create OptionMenu on top **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_header, menu);
        return true;
    }

    /** Setup OptionMenu item click event **/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // Click sign-out
            case R.id.sign_out:
                SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE.txt", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                // Set user login status in USER_FILE.txt to "false"
                editor.putBoolean("LOGGED_IN", false);
                // Switch to LoginActivity
                Intent intent = new Intent(MoviesActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    /** Override BackPressed to switch to ProfileActivity **/
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MoviesActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}