package com.example.demo1_joshpodlich;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RamenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramen);

        Button back_ramen = findViewById(R.id.back_ramen);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            TextView Ramen_label = (TextView)findViewById(R.id.Ramen_label);
            Ramen_label.setText(value);
            if (value.equals("Chicken Strips")) {
                Ramen_label.setTextSize(60);
            } else {
                Ramen_label.setTextSize(96);
            }
        }

        back_ramen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainPage.class));
            }
        });
    }
}