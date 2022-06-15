package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.androidreccomendme.app.AppController;
import com.example.androidreccomendme.utils.Const;
import static com.example.androidreccomendme.utils.ServerMethods.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * The CommentPage class creates the comment activity using a JSON request and CommentLayout adapter in order to list all the comment on the current item
 * @author josh podlich
 */
public class CommentPage extends AppCompatActivity {

    private List<Comment> list = new ArrayList<Comment>();

    private ProgressDialog pDialog;

    private CommentList adapter;

    private String TAG = CommentPage.class.getSimpleName();

    private String tag_json_arry = "jarray_req";





    @Override
    /**
     * Creates the CommentPage activity
     * @param savedInstanceState current Bundle
     * @author josh podlich
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_page);
        Intent CreateComment = new Intent(this,CreateCommentPage.class);
        Intent main = new Intent(this, MainMenu.class);

        Button btnComment = (Button) findViewById(R.id.btnCreateComment);
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method uses an intent in order to start another activity
             * @param View current view
             * @author josh podlich
             */
            public void onClick(View view) {
                startActivity(CreateComment);
            }
        });

        Button btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method uses an intent in order to start another activity
             * @param View current view
             * @author josh podlich
             */
            public void onClick(View view) {
                startActivity(main);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            String value = extras.getString("name");
            TextView textName = (TextView) findViewById(R.id.textName);
            textName.setText(value);

            CreateComment.putExtra("name", value);
            CreateComment.putExtra("category", extras.getString("category"));
        }


        Intent toInfo = new Intent(CommentPage.this, CommentPage.class);

        adapter = new CommentList(this, list, toInfo);

        ListView commentList = findViewById(R.id.commentList);
        commentList.setAdapter(adapter);

        requestCommentJson(Const.URL_JSON_COMMENTS, tag_json_arry, TAG, list, adapter);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);



    }
}