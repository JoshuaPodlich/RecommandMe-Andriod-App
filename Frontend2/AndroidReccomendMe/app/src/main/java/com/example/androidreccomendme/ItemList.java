package com.example.androidreccomendme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * The ItemList class is an extension of BaseAdapter that is used to display Item's in a listview
 * @author Caelan Herzberg
 */
public class ItemList extends BaseAdapter {
    List<Item> cat = new ArrayList<Item>();
    private Activity context;
    private Intent i;
    private Activity activity;
    private LayoutInflater inflater;


    /**
     * The ItemList constructor.
     * @param activity is the origin activity
     * @param cat is the list of items to be displayed inside the list
     * @param i is intent which will be used to send an Item's info to the InfoPage
     * @author Caelan Herzberg
     */
    public ItemList(Activity activity, List<Item> cat, Intent i) {
        this.activity = activity;
        this.cat = cat;
        this.i = i;
    }


    @Override
    /**
     * The getCount method returns size of cat
     * @return int
     * @author Caelan Herzberg
     */
    public int getCount() {
        return cat.size();
    }

    @Override
    /**
     * The getItem method returns an Item in cat corresponding to its position index
     * @param pos the position of Item
     * @return Item
     * @author Caelan Herzberg
     */
    public Object getItem(int pos) {
        return cat.get(pos);
    }

    @Override
    /**
     * The getItem method id of Item
     * @param pos position of Item
     * @return long
     * @author Caelan Herzberg
     */
    public long getItemId(int pos) {
        return pos;
    }



    @Override
    /**
     * The getView method inflates UI elements of the category page according to Category_Layout
     * @return View
     * @author Caelan Herzberg
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.activity_category_layout, null);
        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView textViewDesc = (TextView) convertView.findViewById(R.id.textViewDesc);
        Button buttonView = (Button) convertView.findViewById(R.id.buttonView);

       // buttonView.setText(position);

       buttonView.setTag(position);



        // getting movie data for the row
        Item m = cat.get(position);

        textViewName.setText(cat.get(position).getName());
        textViewDesc.setText(cat.get(position).getDescription());
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method takes the data of a specific Item that buttonView represents and sends info to the InfoPage to be displayed to the user
            * @param convertView the current view
           *  @author Caelan Herzberg
             */
            public void onClick(View convertView) {
                String lol = "data";

                i.putExtra("theID",cat.get(position).getID());
                i.putExtra("theName",cat.get(position).getName());
                i.putExtra("theDescription",cat.get(position).getDescription());
                i.putExtra("theScore", cat.get(position).getScore());
                i.putExtra("thePlatform",cat.get(position).getPlatform());
                i.putExtra("thePic", cat.get(position).getPic());
                i.putExtra("theTime_length", cat.get(position).getTime_length());
                i.putExtra("theDirector", cat.get(position).getDirector());
                i.putExtra("theDate",cat.get(position).getDate());
                i.putExtra("theCountry_of_origin", cat.get(position).getCountry_of_origin());
                i.putExtra("theLanguage", cat.get(position).getLanguage());
                i.putExtra("theURL", cat.get(position).getUrl());
                i.putExtra("theAuthor", cat.get(position).getAuthor());
                i.putExtra("theISBN10", cat.get(position).getISBN10());
                i.putExtra("theISBN13", cat.get(position).getISBN13());
                i.putExtra("thePlace", cat.get(position).getPlace());
                i.putExtra("theCode", cat.get(position).getCode());
                i.putExtra("theAddress", cat.get(position).getAddress());
                i.putExtra("thePriceRange", cat.get(position).getPriceRange());
                i.putExtra("thePhoneNumber", cat.get(position).getPhoneNum());
                i.putExtra("theStar", cat.get(position).getStar());
                i.putExtra("theEpisode", cat.get(position).getEpisode());
                i.putExtra("theLanguage_subtitle", cat.get(position).getLanguage_subtitle());
                i.putExtra("theGenre", cat.get(position).getGenre());
                i.putExtra("thePG_level", cat.get(position).getPG_level());
                i.putExtra("theMs_hour", cat.get(position).getMs_hour());
                i.putExtra("theAgeLimit", cat.get(position).getAgeLimit());
                i.putExtra("theProducer", cat.get(position).getProducer());
                i.putExtra("thePublisher", cat.get(position).getPublisher());
                i.putExtra("thePrice", cat.get(position).getPrice());
                i.putExtra("theCategory", cat.get(position).getCategory());
                i.putExtra("thePages", cat.get(position).getPages());
                //i.putExtra("search", "false");


                activity.startActivity(i);


            }
        });
        return convertView;
    }


}