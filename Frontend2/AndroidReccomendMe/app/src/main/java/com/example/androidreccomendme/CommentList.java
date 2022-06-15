package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * The CommentList class is an adapter used to show the comments
 * @author josh podlich
 */
public class CommentList extends BaseAdapter {

    List<Comment> com = new ArrayList<Comment>();

    private Activity context;
    private Intent i;
    private LayoutInflater inflater;
    private String name;

    public String getName(){
        return name;
    }

    public CommentList()
    {

    }


    /**
     * The constructor for CommentList
     * @param context is the origin context
     * @param nav is the intent
     * @author josh podlich
     */
    public CommentList(Activity context, List<Comment> com, Intent nav)
    {
        this.context = context;
        this.com = com;
        i = nav;
    }

    @Override
    public int getCount() {
        return com.size();
    }

    @Override
    public Object getItem(int pos) {
        return com.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    /**
     * The getView method inflates UI elements of the comment page according to CommentLayout
     * @return view
     * @author josh podlich
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.activity_comment_layout, null);

        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView textViewDesc = (TextView) convertView.findViewById(R.id.textViewDesc);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
        Button buttonView = (Button) convertView.findViewById(R.id.buttonView);

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {


            }
        });


        textViewName.setText(com.get(position).getName());
        textViewDesc.setText(com.get(position).getReview());
        image.setImageResource(0);

        return  convertView;
    }


}