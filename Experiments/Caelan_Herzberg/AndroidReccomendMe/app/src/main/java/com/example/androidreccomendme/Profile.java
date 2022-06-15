package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity implements OnClickListener {


    private Button password, username, profilePic,logOut, log, home, profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        password = (Button) findViewById(R.id.btnPassword);
        username = (Button) findViewById(R.id.btnUsername);
        profilePic = (Button) findViewById(R.id.btnProfilePicture);
        logOut = (Button) findViewById(R.id.btnLogOut);
        log = (Button) findViewById(R.id.btnProfileLogin);
        home = (Button) findViewById(R.id.btnProfileHome);
        profile = (Button) findViewById(R.id.btnProfileProfile);

        password.setOnClickListener(this);
        username.setOnClickListener(this);
        profilePic.setOnClickListener(this);
        logOut.setOnClickListener(this);
        log.setOnClickListener(this);
        home.setOnClickListener(this);
        profile.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnProfileHome:
                startActivity(new Intent(Profile.this,
                        MainActivity.class));
                break;
            case R.id.btnPassword:
                startActivity(new Intent(Profile.this,
                        Password.class));
                break;
            case R.id.btnUsername:
                startActivity(new Intent(Profile.this,
                        Username.class));
                break;
            default:
                break;
        }
    }
}