package com.example.androidreccomendme;

import static com.example.androidreccomendme.utils.ServerMethods.postUserJSON;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * The ChangeUserPage is a class used to change the user's username
 * @author  Caelan Herzberg
 */
public class ChangeUserPage extends AppCompatActivity {

    private Button Change;
    private EditText newUser;
    Intent i;

    @Override
    /**
     * the method onCreate creates the ChangeUserPage activity
     * @author Caelan Herzberg
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        Change = (Button) findViewById(R.id.btnUserChange);
        newUser = (EditText) findViewById(R.id.EditTextUser);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();

        i = new Intent(ChangeUserPage.this, ProfilePage.class);

        Button HomeButton = (Button) findViewById(R.id.btnHomeUser);
        Button LoginButton = (Button) findViewById(R.id.btnLogUser);
        Button ProfileButton = (Button) findViewById(R.id.btnProfileUser);

        //Intent login = new Intent(this,CommentPage.class);
        Intent home = new Intent(this,MainMenu.class);
        Intent Profile = new Intent(this,ProfilePage.class);
        Intent Login = new Intent(this,LoginPage.class);

        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());


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

                String newName = newUser.getText().toString();
                editor.putString("username", newName);
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