package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * The CommentLayout class creates the layout for the comments on the comment page
 * @author josh podlich
 */
public class CommentLayout extends AppCompatActivity {

    @Override
    /**
     * the method onCreate creates CommentLayout activity
     * @author josh podlich
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_layout);
    }
}