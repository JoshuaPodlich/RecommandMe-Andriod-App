package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidreccomendme.utils.Const;
import static com.example.androidreccomendme.utils.ServerMethods.*;

public class LoginPage extends AppCompatActivity {

    private String tag = "testing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Button login = (Button) findViewById(R.id.loginBtn);
        Button register = (Button) findViewById(R.id.registerBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, RegisterPage.class));
            }
        });

        Button home = (Button) findViewById(R.id.btnHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, MainMenu.class));
            }
        });

        Button profile = (Button) findViewById(R.id.btnProfileMenu);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, ProfilePage.class));
            }
        });

        TextView usernameText = (TextView) findViewById(R.id.usernameText);
        TextView passwordText = (TextView) findViewById(R.id.passwordText);

        SharedPreferences lSharedPreference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if(!lSharedPreference.getString("username", "Default_Value").equals("Default_Value"))
        {
            login.setText("Login Out");
        }
        else
        {
            login.setText("Login");
        }

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!lSharedPreference.getString("username", "Default_Value").equals("Default_Value"))
                {
                    lSharedPreference.edit().clear().commit();
                    login.setText("Login");
                }
                else {
                    String username = usernameText.getText().toString();
                    String password = passwordText.getText().toString();


                    loginUser(Const.URL_JSON_USER_CHECK, lSharedPreference.edit(), username, password, tag);
                    //String a = lSharedPreference.getString("username", "Default_Value");


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            if ((usernameText.getText().toString().equals(lSharedPreference.getString("username", "Default_Value"))) && (passwordText.getText().toString().equals(lSharedPreference.getString("password", "Default_Value"))) && (lSharedPreference.getString("banned", "Default_Value").equals("false"))) {
                                startActivity(new Intent(LoginPage.this,
                                        MainMenu.class));
                            }

                        }
                    }, 1000);
                }
            }
        });



    }
}