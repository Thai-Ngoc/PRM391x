package com.example.prm391x_shopmovies_ngoclptse00512x;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    TextView mTxtName, mTxtEmail, mTxtUserId;
    ImageView mImageView;    // Profile picture

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // Declare View objects for manipulation
        createViewObjects();
        // Display user info on View
        updateUserInfo();

        // Setup click event listener of BottomNavigation Bar
        // Switch to MoviesActivity if movies icon is clicked
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.navigation_movies) {
                    Intent intent = new Intent(ProfileActivity.this, MoviesActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
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
            case R.id.sign_out:
                SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE.txt", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("LOGGED_IN", false);
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    /** Update user info into USER_FILE.txt
     * Display user info on View **/
    private void updateUserInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE.txt", MODE_PRIVATE);
        String name = sharedPreferences.getString("USERNAME", null);
        String email = sharedPreferences.getString("EMAIL", null);
        String userId = sharedPreferences.getString("USER_ID", null);
        String imageUrl = sharedPreferences.getString("IMAGE_URL", null);

        mTxtName.setText(name);
        mTxtEmail.setText(email);
        mTxtUserId.setText(userId);
        Picasso.get().load(imageUrl).into(mImageView);
    }

    /** Declare View objects for manipulation **/
    public void createViewObjects() {
        mImageView = findViewById(R.id.image_profile);
        mTxtName = findViewById(R.id.txt_user_name);
        mTxtEmail = findViewById(R.id.txt_user_email);
        mTxtUserId = findViewById(R.id.txt_user_id);
    }

    /** Override BackPressed to switch to MoviesActivity **/
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProfileActivity.this, MoviesActivity.class);
        startActivity(intent);
    }
}