package com.example.demo1_joshpodlich;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Ramen_info_button = findViewById(R.id.Ramen_info_button);

        String ramen="Ramen";
        String chickenstrips="Chicken Strips";
        String apples="Apples";

        Ramen_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this, RamenActivity.class);
                i.putExtra("key",ramen);
                startActivity(i);
            }
        });

        Button Chickenstrips_info_button = findViewById(R.id.Chickenstrips_info_button);

        Chickenstrips_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this, RamenActivity.class);
                i.putExtra("key",chickenstrips);
                startActivity(i);
            }
        });

        Button Apples_info_button = findViewById(R.id.Apples_info_button);

        Apples_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this, RamenActivity.class);
                i.putExtra("key",apples);
                startActivity(i);
            }
        });
    }
}