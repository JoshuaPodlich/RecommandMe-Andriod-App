package com.example.androidreccomendme;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.net.Uri;
import android.widget.VideoView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidreccomendme.app.AppController;
import com.example.androidreccomendme.utils.Const;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovieCategory extends Activity implements OnClickListener {

    private String TAG = MovieCategory.class.getSimpleName();
    private Button btnJsonObj, btnJsonArray;
    private TextView msgResponse;
    private ProgressDialog pDialog;
    private TextView nameMovie, descriptionMovie,dateMovie,scoreMovie,platformMovie, nameMovie2, descriptionMovie2,dateMovie2,scoreMovie2,platformMovie2;
    private ArrayList<String> id = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private ArrayList<String> description = new ArrayList<String>();
    private ArrayList<String> date = new ArrayList<String>();
    private ArrayList<String> score = new ArrayList<String>();
    private ArrayList<String> platform = new ArrayList<String>();
    private ArrayList<String> pic = new ArrayList<String>();
    private ArrayList<String> url = new ArrayList<String>();
    private ArrayList<JSONObject> movieJSONList = new ArrayList<JSONObject>();
    private VideoView simpleVideoView, simpleVideoView2;

    ListView movieListView;
    String[] ListElements = new String[] {"Android","Not Android", "Beans"};


    // These tags will be used to cancel the requests
    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_category);

        movieListView = findViewById(R.id.MovieList);
        final ArrayList<String> pict = new ArrayList<String>();
        final ArrayList<String> a = new ArrayList<String>();
        pict.add("lol");
        pict.add("beans");
        pict.add("drop");

        Intent toInfo = new Intent(MovieCategory.this,ItemInfo.class);

        name.add("Spiderman");
        name.add("Doctor Strange");
        name.add("Shang Chi");

        description.add("there was no way home");
        description.add("things are getting out of hand");
        description.add("cool fighting movie");

        id.add("0");
        id.add("1");
        id.add("2");

        date.add("08/28/97");
        date.add("10/23/08");
        date.add("12/23/18");

        score.add("7");
        score.add("8");
        score.add("7.5");

        platform.add("Theatre");
        platform.add("Netflix");
        platform.add("Amazon Prime");

        url.add("spidermanURL");
        url.add("DoctorStrangeURL");
        url.add("ShangchiURL");



        //ArrayList<JSONArray> outputData = new ArrayList<JSONArray>();
        makeJsonArryReq();


        CategoryList categoryList = new CategoryList(this, name,description,pict,id,date,score,platform,url, toInfo);

        final ArrayAdapter<String> movieAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                pict);


        movieListView.setAdapter(categoryList);

        pict.add("worked");
        categoryList.notifyDataSetChanged();





        //btnJsonObj = (Button) findViewById(R.id.btnJsonObj);
        //btnJsonArray = (Button) findViewById(R.id.btnJsonArray);
        //msgResponse = (TextView) findViewById(R.id.msgResponse);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        //btnJsonObj.setOnClickListener(this);
        //btnJsonArray.setOnClickListener(this);



        //



    }

    /**
     * Making json object request
     * */

    private void makeJsonObjReq() {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
                Const.URL_JSON_OBJECT, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());


                        // msgResponse.setText(response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }

        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Androidhive");
                params.put("email", "abc@androidhive.info");
                params.put("pass", "password123");

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    private void arrayListAdd(ArrayList<String> inputList, String a){
        inputList.add(a);
    }

    private void makeJsonArryReq() {

        JsonArrayRequest req = new JsonArrayRequest(Const.URL_JSON_ARRAY,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        int index = 0;
                        for(int n = 0; n < response.length(); n++)
                        {
                            try {
                                JSONObject movie = response.getJSONObject(n);
                                movieJSONList.add(movie);
                                id.add(movie.getString("movie_id"));
                                name.add(movie.getString("name"));
                               // arrayListAdd(name, movie.getString("name"));
                                description.add(movie.getString("description"));
                                date.add(movie.getString("date"));
                                platform.add(movie.getString("platform"));
                                pic.add(movie.getString("pic"));
                                url.add(movie.getString("url"));
                                score.add(movie.getString("score"));
                               //msgResponse.setText(name.toString());



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req,
                tag_json_arry);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_arry);
    }


    @Override
    public void onClick(View v) {
        /*
        switch (v.getId()) {
            case R.id.btnJsonObj:
                makeJsonObjReq();
                btnJsonObj.setText("clicked");

                break;
            case R.id.btnJsonArray:
                makeJsonArryReq();
                btnJsonArray.setText("clicked");
                break;
        }
*/
    }

}
