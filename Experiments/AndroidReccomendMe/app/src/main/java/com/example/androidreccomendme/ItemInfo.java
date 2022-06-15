package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ItemInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);


        Intent intent = getIntent();
        String name = intent.getStringExtra("theName");
        String description = intent.getStringExtra("theDescription");
        String picture = intent.getStringExtra("thePic");
        String id = intent.getStringExtra("theID");
        String date = intent.getStringExtra("theDate");
        String platform = intent.getStringExtra("thePlatform");
        String url = intent.getStringExtra("theURL");
        String score = intent.getStringExtra("theScore");



       TextView itemName = (TextView) findViewById(R.id.itemName);
       itemName.setText(name);

       TextView itemDescription = (TextView) findViewById(R.id.itemDescription);
       itemDescription.setText(description);

       TextView itemPic = (TextView) findViewById(R.id.itemPic);
       itemPic.setText("Pic: " + "would be pic");

       TextView itemID = (TextView) findViewById(R.id.itemID);
       itemID.setText("ID: " + id);

       TextView itemDate = (TextView) findViewById(R.id.itemDate);
       itemDate.setText("Date: " + date);

       TextView itemPlatform = (TextView) findViewById(R.id.itemPlatform);
       itemPlatform.setText("Platform: " + platform);

       TextView itemURL = (TextView) findViewById(R.id.itemURL);
       itemURL.setText("URL: " + url);

       TextView itemScore = (TextView) findViewById(R.id.itemScore);
       itemScore.setText("Score:" + score);


       // movie.setText(data);


    }
}