package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.androidreccomendme.utils.URL_Processor.*;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.SharedPreferences;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * The ProfilePage creates and inflates the ProfilePage activity. Displays user information and has buttons to change user information.
 * @author  Caelan Herzberg
 */
public class ProfilePage extends AppCompatActivity implements OnClickListener {



    private Button password, username, profilePic,logOut, log, home, profile, admin;
    private ImageView picture;

    private TextView userText;
    @Override
    /**
     * The onCreate method creates and inflates UI elements.
     * @param Bundle
     * @author Caelan Herzberg
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        admin = (Button) findViewById(R.id.Admin);
        password = (Button) findViewById(R.id.btnPassword);
        username = (Button) findViewById(R.id.btnUsername);
        profilePic = (Button) findViewById(R.id.btnProfilePicture);
        logOut = (Button) findViewById(R.id.btnLogOut);
        log = (Button) findViewById(R.id.btnProfileLogin);
        home = (Button) findViewById(R.id.btnProfileHome);
        profile = (Button) findViewById(R.id.btnProfileProfile);
        picture = (ImageView) findViewById(R.id.imageProfilePicture);
        userText = (TextView) findViewById(R.id.textUsername);
        password.setOnClickListener(this);
        username.setOnClickListener(this);
        profilePic.setOnClickListener(this);
        logOut.setOnClickListener(this);
        log.setOnClickListener(this);
        home.setOnClickListener(this);
        profile.setOnClickListener(this);
        admin.setOnClickListener(this);
        log.setOnClickListener(this);
        logOut.setOnClickListener(this);





        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor = mSharedPreference.edit();
        String id=(mSharedPreference.getString("id", "Default_Value"));

       if(id.equals("Default_Value"))
       {
           startActivity(new Intent(ProfilePage.this,
                   LoginPage.class));
       }

        String user=(mSharedPreference.getString("username", "Default_Value"));
        String userpass=(mSharedPreference.getString("password", "Default_Value"));
        String email=(mSharedPreference.getString("email", "Default_Value"));
        String pic=(mSharedPreference.getString("pic", "Default_Value"));
        String gender=(mSharedPreference.getString("gender", "Default_Value"));
        String userid=(mSharedPreference.getString("userid", "Default_Value"));
        String banned=(mSharedPreference.getString("banned", "Default_Value"));
        String isComment=(mSharedPreference.getString("isComment", "Default_Value"));
        String adminVal=(mSharedPreference.getString("admin", "Default_Value"));

        if(adminVal.equals("false"))
        {
            admin.setVisibility(View.GONE);
        }



        pic = pic + ".jpeg";
        Picasso.get().load(pic).into(picture);

        Process(pic);

       // password.setText(userpass);
        userText.setText(user);

    }




    @Override
    /**
     * the onClick method sends the user to different activities depending on which button was clicked
     * @param View
     * @author Caelan Herzberg
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnProfileHome:
                startActivity(new Intent(ProfilePage.this,
                        MainMenu.class));
                break;
            case R.id.btnPassword:
                startActivity(new Intent(ProfilePage.this,
                        ChangePassPage.class));
                break;
            case R.id.btnUsername:
                startActivity(new Intent(ProfilePage.this,
                        ChangeUserPage.class));
                break;
            case R.id.btnProfilePicture:
                startActivity(new Intent(ProfilePage.this,
                        ChangePic.class));
                break;
            case R.id.Admin:
                startActivity(new Intent(ProfilePage.this,
                        AdminPage.class));
                break;
            case R.id.btnProfileLogin:
                startActivity(new Intent(ProfilePage.this,
                        LoginPage.class));
            case R.id.btnLogOut:

                final SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editors = pref.edit();
                editors.clear();
                editors.commit();
                startActivity(new Intent(ProfilePage.this,
                        LoginPage.class));
            default:
                break;
        }
    }



}