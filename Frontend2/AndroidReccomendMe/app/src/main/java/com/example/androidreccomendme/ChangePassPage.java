package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import static com.example.androidreccomendme.utils.ServerMethods.*;
/**
 * The ChangePassPage is a class used to change a user's password
 * @author  Caelan Herzberg
 */
public class ChangePassPage extends AppCompatActivity {

    private Button Change, LoginButton,HomeButton,ProfileButton;
    private EditText currentPassword, newPassword;
    private TextView label;
    Intent i;

    @Override
    /**
     * the method onCreate creates the ChangePassPage activity
     * @author Caelan Herzberg
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);



        Change = (Button) findViewById(R.id.buttonChangePassword);
        currentPassword = (EditText) findViewById(R.id.editCurrentPassword);
        newPassword = (EditText) findViewById(R.id.editNewPassword);
        label = (TextView) findViewById(R.id.passLabel);


        //LoginButton = (Button) findViewById(R.id.btnLogPass);
        //HomeButton = (Button) findViewById(R.id.btnHomePass);
       // ProfileButton = (Button) findViewById(R.id.btnProfilePass);

        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String password=(mSharedPreference.getString("password", "Default_Value"));

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();

        i = new Intent(ChangePassPage.this, ProfilePage.class);

        Button HomeButton = (Button) findViewById(R.id.btnHomePass);
        Button LoginButton = (Button) findViewById(R.id.btnLogPass);
        Button ProfileButton = (Button) findViewById(R.id.btnProfilePass);

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



               if(password.equals(currentPassword.getText().toString()))
                {
                    String newPass = newPassword.getText().toString();
                    editor.putString("password", newPass);
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
               else
               {

                   label.setText("Current Password is not correct");

               }



            }
        });
    }
}