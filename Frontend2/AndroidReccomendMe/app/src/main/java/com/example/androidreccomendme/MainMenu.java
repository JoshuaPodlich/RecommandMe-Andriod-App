package com.example.androidreccomendme;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.androidreccomendme.utils.ServerMethods.*;


/**
 * The MainMenu class creates the main menu of the program
 * @author Caelan Herzberg
 */
public class MainMenu extends Activity implements OnClickListener {
    private Button search,movie, resturaunt, tv, books, videogames, log, home, profile;
    private Intent i, x, p,c;
    private TextView label;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private EditText query;

    @Override

    /**
     * onCreate is a method that creates and inflates UI elements of the MainMenu activity such as buttons that lead to other pages
     * @param savedInstanceState current Bundle
     * @author Caelan Herzberg
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        i = new Intent(MainMenu.this, CategoryPage.class);
        x = new Intent(MainMenu.this, InfoPage.class);
        p = new Intent(MainMenu.this, ProfilePage.class);
        c = new Intent(MainMenu.this, LoginPage.class);




      prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
      editor = prefs.edit();




        movie = (Button) findViewById(R.id.btnMovies);
        resturaunt = (Button) findViewById(R.id.btnResturaunt);
        tv = (Button) findViewById(R.id.btnTV);
        books = (Button) findViewById(R.id.btnBooks);
        videogames = (Button) findViewById(R.id.btnVideogamesMenu);
        log = (Button) findViewById(R.id.btnLog);
        home = (Button) findViewById(R.id.btnHome);
        profile = (Button) findViewById(R.id.btnProfileMenu);
        query = (EditText) findViewById(R.id.searchCategory);
        search = (Button) findViewById(R.id.btnSearch);
        label = (TextView) findViewById(R.id.searchText);

        movie.setOnClickListener(this);
        resturaunt.setOnClickListener(this);
        tv.setOnClickListener(this);
        books.setOnClickListener(this);
        videogames.setOnClickListener(this);
        log.setOnClickListener(this);
        home.setOnClickListener(this);
        profile.setOnClickListener(this);
        log.setOnClickListener(this);
        search.setOnClickListener(this);




/*
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("id", "2");
        editor.putString("username", "Caelan");
        editor.putString("password", "Herzberg");
        editor.putString("email", "caelan@gmail.com");
        editor.putString("pic", "https://i.pinimg.com/736x/26/ce/c0/26cec0279625be0769e58984ee770fef--terrapin-album.jpg");
        editor.putString("gender", "male");
        editor.putString("UUID", "beans");
        editor.putString("banned", "false");
        editor.putString("isComment", "false");
        editor.commit();
        */




         String tag_json_obj = "jobj_req";

        //makeJsonObjReq(tag_json_obj);






    }

    @Override
    /**
     * The onClick method, depending on which button was select, starts the activity corresponding to the button selected. If the button was a category button information on which category was selected is sent to the next page
     * @author Caelan Herzberg
     * @param View current view
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMovies:
                i.putExtra("categoryType", "movie".toString());
                editor.putString("search", "0");
                editor.commit();
                editor.apply();
                startActivity(i);
               //btnString.setText("lol");
                break;
            case R.id.btnBooks:
                i.putExtra("categoryType","books".toString());
                editor.putString("search", "0");
                editor.commit();
                editor.apply();
                startActivity(i);
                //btnString.setText("lol");
                break;
            case R.id.btnTV:
                i.putExtra("categoryType","tv".toString());
                editor.putString("search", "0");
                editor.commit();
                editor.apply();
                startActivity(i);
                //btnString.setText("lol");
                break;
            case R.id.btnResturaunt:
                i.putExtra("categoryType","restaurant".toString());
                editor.putString("search", "0");
                editor.commit();
                editor.apply();
                startActivity(i);
                //btnString.setText("lol");
                break;
            case R.id.btnVideogamesMenu:
                i.putExtra("categoryType","videogames".toString());
                editor.putString("search", "0");
                editor.commit();
                editor.apply();
                startActivity(i);
                //btnString.setText("lol");
                break;
            case R.id.btnHome:




                break;
            case R.id.btnLog:

                startActivity(c);

                break;
            case R.id.btnProfileMenu:
                startActivity(p);
                break;
            case R.id.btnSearch:

                //i.putExtra("query", query.getText().toString());
                String ad = (String) query.getText().toString();
                //JsonObjectRequest("a","");
                String TAG = MainMenu.class.getSimpleName();
                makeJsonObjReqSearch(TAG,ad,prefs);



                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        String worked=(prefs.getString("success", "Default_Value"));

                        if(worked.equals("0"))
                        {

                            label.setText("Not a Valid Item, Try Again.");

                        }
                        else
                        {
                            label.setText("Type Item Name Below");
                            startActivity(x);
                        }

                    }
                }, 3000);
                break;
            default:
                break;
        }
    }

}
