package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPage extends AppCompatActivity {

    Intent i,x,p, q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);


        Button HomeButton = (Button) findViewById(R.id.btnHomeAdmin);
        Button LoginButton = (Button) findViewById(R.id.btnLogAdmin);
        Button ProfileButton = (Button) findViewById(R.id.btnProfileAdmin);
        Button Banned = (Button) findViewById(R.id.btnViewBanned);
        Button Admin = (Button) findViewById(R.id.btnViewAdmins);
        Button Users = (Button) findViewById(R.id.btnViewUsers);

        //Intent login = new Intent(this,CommentPage.class);
        Intent home = new Intent(this,MainMenu.class);
        Intent Profile = new Intent(this,ProfilePage.class);

        i = new Intent(AdminPage.this, Users.class);
        x = new Intent(AdminPage.this, InfoPage.class);
        p = new Intent(AdminPage.this, ProfilePage.class);
        q = new Intent(AdminPage.this, LoginPage.class);

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                startActivity(home);


            }
        });

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                i.putExtra("userType", "admin");
                startActivity(i);


            }
        });

        Banned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                i.putExtra("userType", "banned");
                startActivity(i);


            }
        });

        Users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                i.putExtra("userType", "user");
                startActivity(i);


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
                startActivity(q);


            }
        });
    }
}