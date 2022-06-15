package com.example.androidreccomendme;

import static com.example.androidreccomendme.utils.ServerMethods.postUserJSON;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class ChangePic extends AppCompatActivity {

    private Button Change;
    private EditText newPic;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pic);



            Change = (Button) findViewById(R.id.btnPicChange);
            newPic = (EditText) findViewById(R.id.EditTextPic);

        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = prefs.edit();

            i = new Intent(ChangePic.this, ProfilePage.class);

        Button HomeButton = (Button) findViewById(R.id.btnHomePic);
        Button LoginButton = (Button) findViewById(R.id.btnLogPic);
        Button ProfileButton = (Button) findViewById(R.id.btnProfilePic);

        //Intent login = new Intent(this,CommentPage.class);
        Intent home = new Intent(this,MainMenu.class);
        Intent Profile = new Intent(this,ProfilePage.class);
        Intent Login = new Intent(this,LoginPage.class);

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                startActivity(home);


            }
        });

        ProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                startActivity(Profile);


            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                startActivity(Login);


            }
        });




            Change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View convertView) {
                    // context.startActivity(ProfilePage.class);

                    String newPicture = newPic.getText().toString();
                    editor.putString("pic", newPicture);
                    editor.commit();

                    JSONObject a = new JSONObject();

                    try {
                        a.put("id", mSharedPreference.getString("id", "Default_Value"));
                        a.put("username", mSharedPreference.getString("username", "Default_Value"));
                        a.put("password", mSharedPreference.getString("password", "Default_Value"));
                        a.put("email", mSharedPreference.getString("email", "Default_Value"));
                        a.put("pic", mSharedPreference.getString("pic", "Default_Value"));
                        a.put("gender", mSharedPreference.getString("gender", "Default_Value"));
                        a.put("userid", mSharedPreference.getString("userid", "Default_Value"));
                        a.put("banned", mSharedPreference.getString("banned", "Default_Value"));
                        a.put("comment", mSharedPreference.getString("isComment", "Default_Value"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    postUserJSON("",a, "http://coms-309-018.class.las.iastate.edu:8080/User/register");


                    startActivity(i);


                }
            });
    }
}