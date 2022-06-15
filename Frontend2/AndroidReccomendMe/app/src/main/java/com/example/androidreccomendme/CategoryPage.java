package com.example.androidreccomendme;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import static com.example.androidreccomendme.utils.ServerMethods.*;
import static com.example.androidreccomendme.utils.URL_Processor.*;
import android.content.SharedPreferences;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidreccomendme.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * The CategoryPage class creates the category activity using a JSON request and ListView adapter in order to list all items in a category
 * @author Caelan Herzberg
 */
public class CategoryPage extends Activity  {
    private List<Item> list = new ArrayList<Item>();
    private String TAG = CategoryPage.class.getSimpleName();
    private Button btnJsonObj, btnJsonArray;
    private TextView msgResponse;
    private ProgressDialog pDialog;
    private int infoType = 0;
    String url = "";
    private ArrayList<JSONObject> movieJSONList = new ArrayList<JSONObject>();
    private ItemList adapter;
    private String type;
    ListView movieListView;



    // These tags will be used to cancel the requests
    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";



    @Override
    /**
     * The method onCreate creates and inflates the CategoryPage activity.
     * Accepts type information from main menu and selects a corresponding URL to make a volley request from
     * Creates ListView adapter
     * Calls requestCategoryJSON and binds information from JSON array to UI elements. Uses ListView to update list visuals.
     * @param savedInstanceState current Bundle
     * @author Caelan Herzberg
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        Intent thisIntent = getIntent();
        Intent toInfo = null;
        type = thisIntent.getStringExtra("categoryType");

        Button HomeButton = (Button) findViewById(R.id.btnHomeCat);
        Button LoginButton = (Button) findViewById(R.id.btnLogCat);
        Button ProfileButton = (Button) findViewById(R.id.btnProfileCat);

        Intent comment = new Intent(this,CommentPage.class);
        Intent home = new Intent(this,MainMenu.class);
        Intent Profile = new Intent(this,ProfilePage.class);
        Intent Login = new Intent(this,LoginPage.class);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                startActivity(Login);


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
                //startActivity(home);


            }
        });

        if(type.equals("movie"))
        {
            infoType = 1;
           // url = "https://4ce51a27-336f-4dc1-8b2a-8f1963f87595.mock.pstmn.io/Movie";
            url = "http://coms-309-018.class.las.iastate.edu:8080/Movie/info";
            //makeJsonObjReq(TAG,url);
            toInfo = new Intent(CategoryPage.this, InfoPage.class);
            //startActivity(toInfo);
        }
        if(type.equals("books"))
        {
            infoType = 2;
            //url = "https://4ce51a27-336f-4dc1-8b2a-8f1963f87595.mock.pstmn.io/Book";
            url = "http://coms-309-018.class.las.iastate.edu:8080/Book/info";
            toInfo = new Intent(CategoryPage.this, InfoPage.class);
        }
        if(type.equals("restaurant"))
        {
            infoType = 3;
            url = "http://coms-309-018.class.las.iastate.edu:8080/Restaurant/info";
            toInfo = new Intent(CategoryPage.this, InfoPage.class);
        }
        if(type.equals("tv"))
        {
            infoType = 4;
            url = "http://coms-309-018.class.las.iastate.edu:8080/TVShow/info";
            toInfo = new Intent(CategoryPage.this, InfoPage.class);
        }

        if(type.equals("videogames"))
        {
            infoType = 5;
            url = "http://coms-309-018.class.las.iastate.edu:8080/VideoGame/info";
            toInfo = new Intent(CategoryPage.this, InfoPage.class);
        }

        movieListView = findViewById(R.id.MovieList);
        adapter = new ItemList(this,list, toInfo);
        movieListView.setAdapter(adapter);






        JSONObject a = new JSONObject();

        try {
            a.put("id", "2");
            a.put("username", "john");
            a.put("password", "perg");
            a.put("email", "jph@iastate.edu");
            a.put("pic", "beandadws");
            a.put("gender", "male");
            a.put("pic", "beans");
            a.put("UUID", "46652");
            a.put("banned", "0");
            a.put("isComment", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }




      //  postUserJSON(TAG,a);
      //  makeJsonObjReq(TAG,url);
     //   Intent x = null;
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //makeJsonObjReqSearch(TAG,url,prefs);
        //startActivity(toInfo);
     requestCategoryJson(url,tag_json_arry,type,TAG,infoType,list,adapter);


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
    }






}


