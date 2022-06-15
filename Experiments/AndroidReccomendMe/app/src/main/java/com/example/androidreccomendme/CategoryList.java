package com.example.androidreccomendme;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class CategoryList extends ArrayAdapter<String> {
    private ArrayList<String> movieName;
    private ArrayList<String> movieDesc;
    private ArrayList<String> picDir;
    private ArrayList<String> movieID;
    private ArrayList<String> movieDate;
    private ArrayList<String> movieScore;
    private ArrayList<String> moviePlatform;
    private ArrayList<String> movieURL;
    private Activity context;
    private Intent i;
    private String name;

    public String getName(){
        return name;
    }

    public CategoryList(Activity context, ArrayList<String> names, ArrayList<String> desc, ArrayList<String> imageDir,ArrayList<String> id, ArrayList<String> date, ArrayList<String> score, ArrayList<String> platform,ArrayList<String> url, Intent nav) {
        super(context, R.layout.activity_list_layout, names);
        this.context = context;
        movieName = names;
        movieDesc = desc;
        picDir = imageDir;
        movieID = id;
        movieDate = date;
        movieScore = score;
        moviePlatform = platform;
        movieURL = url;
        i = nav;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_list_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewDesc = (TextView) listViewItem.findViewById(R.id.textViewDesc);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.imageView);
        Button buttonView = (Button) listViewItem.findViewById(R.id.buttonView);
        name = movieName.get(position);
        textViewName.setText(movieName.get(position));
        textViewDesc.setText(movieDesc.get(position));
        image.setImageResource(0);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // context.startActivity(Profile.class);
                String lol = "data";
                int a = position;
                i.putExtra("theName",movieName.get(position));
                i.putExtra("theDescription",movieDesc.get(position));
                i.putExtra("thePic", "0");
                i.putExtra("theID",movieID.get(position));
                i.putExtra("theDate", movieDate.get(position));
                i.putExtra("theScore", movieScore.get(position));
                i.putExtra("thePlatform",moviePlatform.get(position));
                i.putExtra("theURL", movieURL.get(position));
                context.startActivity(i);


            }
        });
        return  listViewItem;
    }

    public void onClick(View v) {



    }
}