package com.example.prm391x_shopmovies_ngoclptse00512x;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    private LoginButton mBtnLoginFB;    // Facebook login button
    private SignInButton mBtnLoginGG;   // Google login button

    CallbackManager callbackManager;

    final int RC_SIGN_IN = 100; // Google request code
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().logOut();    // Logout facebook

        setContentView(R.layout.activity_login);

        // Declare View objects for manipulation
        createViewObjects();

        // Configure Google sign-in to request the user's ID, email address, and avatar
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mBtnLoginGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();   // Sign in Google account
            }
        });

        // Configure Facebook sign-in to request the user's ID, email address, and avatar
        mBtnLoginFB.setReadPermissions(Arrays.asList("public_profile", "email"));
        setLoginButton();
    }

    /** Create sign-in buttons objects */
    public void createViewObjects() {
        mBtnLoginFB = findViewById(R.id.login_button_facebook);
        mBtnLoginGG = findViewById(R.id.login_button_google);
        mBtnLoginGG.setSize(SignInButton.SIZE_WIDE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        signOut();  // Log out of account every time activity is opened
    }

    @Override
    public void onBackPressed() {
        // Send Application to background on back pressed
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /******************************* GOOGLE SIGN-IN CONFIG ***************************/
    /** Google sign-in */
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            // Signed in successfully, show authenticated UI.
            if (acct != null) {
                String name = acct.getDisplayName();
                String email = acct.getEmail();
                String userId = acct.getId();
                String imageUrl = String.valueOf(acct.getPhotoUrl());
                // Update user info into SharedPreference file
                rememberUser(name, email, userId, imageUrl, true, "google");
                // Switch to MovieActivity
                openMoviesActivity();
            }
        } catch (ApiException e) {
            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());
        }
    }

    /******************************* FACEBOOK SIGN-IN CONFIG ***************************/
    private void setLoginButton() {
        mBtnLoginFB.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                result();
            }
            @Override
            public void onCancel() {
            }
            @Override
            public void onError(FacebookException error) {
            }
        });
    }

    private void result() {
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String email = object.getString("email");
                    String name = object.getString("name");
                    String userId = object.getString("id");
                    String imageUrl = object.getJSONObject("picture").getJSONObject("data").getString("url");
                    // Update user info into SharedPreference file
                    rememberUser(name, email, userId, imageUrl, true, "facebook");
                    // Switch to MovieActivity
                    openMoviesActivity();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "name,email,id,picture.width(150).height(150)");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }

    /** Handle Sign In result for both Facebook and Google account */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Google sign-in result handle
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

        // Facebook sign-in result handle
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    /** Sign Out for both Facebook and Google account
     * Clear user info */
    private void signOut() {
        // Facebook logout
        LoginManager.getInstance().logOut();

        // Google logout
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //clearUserInfo();
                    }
                });

        // Clear user info in SharedPreference file
        rememberUser(null, null, null, null, false, null);
    }

    /** Save/ Clear user info into SharedPreference file */
    public void rememberUser(String name, String email, String userId, String imageUrl, boolean loggedIn, String account) {
        // Create and call SharedPreference file for editing
        SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE.txt", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Save user info if logged in
        if(loggedIn) {
            editor.putString("USERNAME", name);
            editor.putString("EMAIL", email);
            editor.putString("USER_ID", userId);
            editor.putString("IMAGE_URL", imageUrl);
            editor.putBoolean("LOGGED_IN", true);
            editor.putString("ACCOUNT", account);
        }
        // Clear user info if logged out
        else {
            editor.clear();
        }
        editor.commit();
    }

    /** Switch to MovieActivity */
    private void openMoviesActivity() {
        Intent intent = new Intent(LoginActivity.this, MoviesActivity.class);
        startActivity(intent);
    }
}