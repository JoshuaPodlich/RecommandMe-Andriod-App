package com.example.androidreccomendme;

import static com.example.androidreccomendme.utils.ServerMethods.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidreccomendme.utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * The CreateCommentPage class creates the CreateCommentPage activity
 * @author josh podlich
 */
public class CreateCommentPage extends AppCompatActivity {

    @Override
    /**
     * Creates the CreateCommentPage activity
     * @param savedInstanceState current Bundle
     * @author josh podlich
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_comment_page);

        final SharedPreferences cSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String userid=(cSharedPreference.getString("userid", "Default_Value"));
        String username =(cSharedPreference.getString("username", "Default_Value"));
        String password =(cSharedPreference.getString("password", "Default_Value"));

        String id=(cSharedPreference.getString("id", "Default_Value"));

        if(id.equals("Default_Value"))
        {
            startActivity(new Intent(CreateCommentPage.this,
                    LoginPage.class));
        }

        TextView rating = (TextView) findViewById(R.id.ratingText);
        TextView reviewText = (TextView) findViewById(R.id.CommentTextBox);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button createCommentbtn = (Button) findViewById(R.id.btnSubmit);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method uses an intent in order to start another activity
             * @param View current view
             * @author josh podlich
             */
            public void onClick(View view) {
                startActivity(new Intent(CreateCommentPage.this,
                        CommentPage.class));
            }
        });

        createCommentbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Integer.parseInt(rating.getText().toString()) > 0 && Integer.parseInt(rating.getText().toString()) < 11) {
                    String category = "";
                    String name = "";

                    Bundle extras = getIntent().getExtras();
                    if (extras != null) {
                        category = extras.getString("category");
                        name = extras.getString("name");
                    }

                    String url = Const.URL_JSON_COMMENT_POST + userid + "/" + category + "/" + name;

                    String url2 = "http://coms-309-018.class.las.iastate.edu:8080/User/get/" + username + "/" + password;


                    try {
                        JSONObject comment = new JSONObject();
                        comment.put("rating", Integer.parseInt(rating.getText().toString()));
                        comment.put("reviewText", reviewText.getText().toString());
                        comment.put("upVotes", false);

                        getUserInfo(url2, username, password, "user-info", comment, url);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    startActivity(new Intent(CreateCommentPage.this,
                            MainMenu.class));
                } }
        });
    }
}