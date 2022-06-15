package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Comment extends AppCompatActivity {

    private String name;
    private String review;
    private String pic;
    private boolean upvote;

    public Comment()
    {
        this.upvote = false;
    }

    public Comment(String pic, String name, String review)
    {
        this.name = name;
        this.pic = pic;
        this.review = review;
        this.upvote = false;
    }

    public String getPic()
    {
        return pic;
    }

    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getReview()
    {
        return review;
    }

    public void setReview(String review)
    {
        this.review = review;
    }

    public boolean getVote()
    {
        return upvote;
    }

    public void setVote(boolean vote)
    {
        this.upvote = vote;
    }


    public void changeUpvote()
    {
        if(upvote == false)
        {
            upvote = true;
        }
        else
        {
            upvote = false;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}