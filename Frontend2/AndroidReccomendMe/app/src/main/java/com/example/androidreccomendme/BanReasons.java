package com.example.androidreccomendme;

import static com.example.androidreccomendme.utils.ServerMethods.postUserJSON;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class BanReasons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_reasons);

        Intent menu = new Intent(this,AdminPage.class);
        Intent home = new Intent(this,MainMenu.class);
        Intent Profile = new Intent(this,ProfilePage.class);
        Intent Login = new Intent(this,LoginPage.class);

        Button buttonBan = (Button) findViewById(R.id.btnReasons);


        Button HomeButton = (Button) findViewById(R.id.btnHomeReasons);
        Button LoginButton = (Button) findViewById(R.id.btnLogReasons);
        Button ProfileButton = (Button) findViewById(R.id.btnProfileReasons);

        Intent intent = getIntent();
        // id = intent.getStringExtra("theID");
        String user = intent.getStringExtra("user");
        String userid = intent.getStringExtra("userid");
        EditText reason = (EditText) findViewById(R.id.EditTextReasons);




        buttonBan.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method takes the data of a specific Item that buttonView represents and sends info to the InfoPage to be displayed to the user
             * @param convertView the current view
             *  @author Caelan Herzberg
             */
            public void onClick(View convertView) {



                /*
                JSONObject b = new JSONObject();
                try {

                    b.put("id", intent.getStringExtra("id"));
                    b.put("username", user);
                    b.put("password", intent.getStringExtra("password"));
                    b.put("email", intent.getStringExtra("email"));
                    b.put("pic", intent.getStringExtra("pic"));
                    b.put("gender", intent.getStringExtra("gender"));
                    b.put("userid", userid);
                    b.put("banned", "true");
                    b.put("comment", intent.getStringExtra("comment"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                 */

                JSONObject a = new JSONObject();
                try {



                    if(reason.getText() == null)
                    {
                        a.put("reasons", "No Reason Specified");
                    }
                    else
                    {
                        a.put("reasons", reason.getText().toString());
                    }

                    a.put("userid",userid);




                } catch (JSONException e) {
                    e.printStackTrace();
                }




                postUserJSON("",a, "http://coms-309-018.class.las.iastate.edu:8080/User/ban/" + userid);



                startActivity(menu);

            }
        });

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










    }
}