package com.example.androidreccomendme;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MainActivity extends Activity implements OnClickListener {
    private Button movie, resturaunt, tv, books, videogames, log, home, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        movie = (Button) findViewById(R.id.btnMovies);
        resturaunt = (Button) findViewById(R.id.btnResturaunt);
        tv = (Button) findViewById(R.id.btnTV);
        books = (Button) findViewById(R.id.btnBooks);
        videogames = (Button) findViewById(R.id.btnVideogames);
        log = (Button) findViewById(R.id.btnLog);
        home = (Button) findViewById(R.id.btnHome);
        profile = (Button) findViewById(R.id.btnProfile);

        movie.setOnClickListener(this);
        resturaunt.setOnClickListener(this);
        tv.setOnClickListener(this);
        books.setOnClickListener(this);
        videogames.setOnClickListener(this);
        log.setOnClickListener(this);
        home.setOnClickListener(this);
        profile.setOnClickListener(this);

        //btnString = (Button) findViewById(R.id.btnStringRequest);
        //btnJson = (Button) findViewById(R.id.btnJsonRequest);
        //btnImage = (Button) findViewById(R.id.btnImageRequest);

        // button click listeners
       // btnString.setOnClickListener(this);
        //btnJson.setOnClickListener(this);
        //btnImage.setOnClickListener(this);

        //btnString = (Button) findViewById(R.id.btnStringRequest);
        //btnJson = (Button) findViewById(R.id.btnJsonRequest);
        //btnImage = (Button) findViewById(R.id.btnImageRequest);

        // button click listeners
        // btnString.setOnClickListener(this);
        //btnJson.setOnClickListener(this);
        //btnImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMovies:
                startActivity(new Intent(MainActivity.this,
                        MovieCategory.class));
               //btnString.setText("lol");
                break;
            case R.id.btnHome:

                break;
            case R.id.btnProfile:
                startActivity(new Intent(MainActivity.this,
                        Profile.class));
                break;
            default:
                break;
        }
    }

}
