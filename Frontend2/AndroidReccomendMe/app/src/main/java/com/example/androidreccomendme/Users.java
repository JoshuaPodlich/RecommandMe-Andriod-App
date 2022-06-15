package com.example.androidreccomendme;

import static com.example.androidreccomendme.utils.ServerMethods.requestCategoryJson;
import static com.example.androidreccomendme.utils.ServerMethods.requestUsersJson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Users extends AppCompatActivity {




    private List<User> list = new ArrayList<User>();
    private String TAG = Users.class.getSimpleName();
    private Button btnJsonObj, btnJsonArray;
    private TextView msgResponse;
    private ProgressDialog pDialog;
    private int infoType = 0;
    String url = "";
    private ArrayList<JSONObject> movieJSONList = new ArrayList<JSONObject>();
    private UserList adapter;
    private String type;
    ListView userListView;



    // These tags will be used to cancel the requests
    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);


        Intent thisIntent = getIntent();
        Intent toInfo = null;
        Intent toReasons = null;
        toInfo = new Intent(this,AdminPage.class);
        toReasons = new Intent(this,BanReasons.class);
        String type = thisIntent.getStringExtra("userType");

        Intent home = new Intent(this,MainMenu.class);
        Intent Profile = new Intent(this,ProfilePage.class);
        Intent Login = new Intent(this,LoginPage.class);

        Button HomeButton = (Button) findViewById(R.id.btnHomeUserList);
        Button LoginButton = (Button) findViewById(R.id.btnLogUserList);
        Button ProfileButton = (Button) findViewById(R.id.btnProfileUserList);





        if(type.equals("admin"))
        {
            infoType = 2;
            // url = "https://4ce51a27-336f-4dc1-8b2a-8f1963f87595.mock.pstmn.io/Movie";
            url = "http://coms-309-018.class.las.iastate.edu:8080/Admin/info";
            //makeJsonObjReq(TAG,url);
            //toInfo = new Intent(Users.this, InfoPage.class);
            //startActivity(toInfo);
        }
        if(type.equals("user"))
        {
            infoType = 1;
            //url = "https://4ce51a27-336f-4dc1-8b2a-8f1963f87595.mock.pstmn.io/Book";
            url = "http://coms-309-018.class.las.iastate.edu:8080/User/info";
            //toInfo = new Intent(CategoryPage.this, InfoPage.class);
        }
        if(type.equals("banned"))
        {
            infoType = 3;
            url = "http://coms-309-018.class.las.iastate.edu:8080/BanUser/info";
            //toInfo = new Intent(Users.this, InfoPage.class);
        }


         userListView = findViewById(R.id.UserList);
        adapter = new UserList(this,list, toInfo, toReasons);
        userListView.setAdapter(adapter);










        //  postUserJSON(TAG,a);
        //  makeJsonObjReq(TAG,url);
        //   Intent x = null;
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //makeJsonObjReqSearch(TAG,url,prefs);
        //startActivity(toInfo);
        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String myID=(mSharedPreference.getString("userid", "Default_Value"));


        requestUsersJson(url,tag_json_arry,type,TAG,infoType,list,adapter,myID);


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);


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