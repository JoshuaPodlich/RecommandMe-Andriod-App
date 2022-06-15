package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import static com.example.androidreccomendme.utils.ServerMethods.*;

import com.example.androidreccomendme.utils.Const;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        TextView username = (TextView) findViewById(R.id.usernameTextInput);
        TextView password = (TextView) findViewById(R.id.passwordTextInput);
        TextView email = (TextView) findViewById(R.id.emailTextInput);
        TextView info = (TextView) findViewById(R.id.registerInfoText);

        Button register = (Button) findViewById(R.id.registerUserbtn);

        RadioButton male = (RadioButton) findViewById(R.id.radioButtonMale);
        RadioButton female = (RadioButton) findViewById(R.id.radioButtonFemale);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("") || username.getText().toString().equals("Enter Username here") || password.getText().toString().equals("") || password.getText().toString().equals("Enter Password here") || (!male.isChecked() && !female.isChecked()))
                {
                    info.setText("Please make sure all information is filled out");
                }
                else if(!email.getText().toString().contains("@"))
                {
                    info.setText("Please enter a valid email");
                }
                else
                {
                    JSONObject user = new JSONObject();
                    try {
                        user.put("username", username.getText().toString());
                        user.put("password", password.getText().toString());
                        user.put("email", email.getText().toString());
                        user.put("banned", false);
                        user.put("comment", false);
                        user.put("admin", false);

                        if(male.isChecked())
                        {
                            user.put("gender", "male");
                        }
                        else
                        {
                            user.put("gender", "female");
                        }
                        postUserJSON("user-create", user, Const.URL_JSON_USER_POST);
                        startActivity(new Intent(RegisterPage.this, LoginPage.class));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}