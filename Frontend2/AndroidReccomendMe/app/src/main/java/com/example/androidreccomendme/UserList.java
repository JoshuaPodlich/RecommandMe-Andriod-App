package com.example.androidreccomendme;

import static com.example.androidreccomendme.utils.ServerMethods.deleteUserJSON;
import static com.example.androidreccomendme.utils.ServerMethods.postUserJSON;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The ItemList class is an extension of BaseAdapter that is used to display Item's in a listview
 * @author Caelan Herzberg
 */
public class UserList extends BaseAdapter {
    List<User> user = new ArrayList<User>();
    private Activity context;
    private Intent i,b;
    private Activity activity;
    private LayoutInflater inflater;


    /**
     * The ItemList constructor.
     * @param activity is the origin activity
     * @param user is the list of items to be displayed inside the list
     * @param i is intent which will be used to send an Item's info to the InfoPage
     * @author Caelan Herzberg
     */
    public UserList(Activity activity, List<User> user, Intent i, Intent b) {
        this.activity = activity;
        this.user = user;
        this.i = i;
        this.b = b;
    }


    @Override
    /**
     * The getCount method returns size of cat
     * @return int
     * @author Caelan Herzberg
     */
    public int getCount() {
        return user.size();
    }


    /**
     * The getItem method returns an Item in cat corresponding to its position index
     * @param pos the position of Item
     * @return Item
     * @author Caelan Herzberg
     */
    @Override
    public Object getItem(int pos) {
        return user.get(pos);
    }


    /**
     * The getItem method id of Item
     * @param pos position of Item
     * @return long
     * @author Caelan Herzberg
     */
    @Override
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
            convertView = inflater.inflate(R.layout.activity_user_layout, null);

        TextView textViewName,textViewDesc,textViewAdmin,textViewComment,textViewBanned;
        Button buttonAdmin, buttonBanned, buttonComment;

        textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewDesc = (TextView) convertView.findViewById(R.id.textViewDesc);
        textViewAdmin = (TextView) convertView.findViewById(R.id.textIsAdmin);
        textViewComment = (TextView) convertView.findViewById(R.id.textIsAbleToComment);
        textViewBanned= (TextView) convertView.findViewById(R.id.textIsBanned);
        buttonAdmin = (Button) convertView.findViewById(R.id.buttonToggleAdmin);
        buttonBanned = (Button) convertView.findViewById(R.id.buttonToggleBanned);
        buttonComment = (Button) convertView.findViewById(R.id.buttonToggleComment);




        if(user.get(position).getType() == 1)
        {






            textViewAdmin.setText("IsAdmin: " + user.get(position).getAdmin());
            textViewComment.setText("Can Comment: " + user.get(position).getIsComment());
            textViewBanned.setText("IsBanned: " + user.get(position).getBanned());

        }

        if(user.get(position).getType() == 3)
        {
            textViewAdmin.setText("Reasons:" + user.get(position).getReasons());

            buttonAdmin.setVisibility(View.GONE);
            buttonBanned.setText("Unban");
            buttonComment.setVisibility(View.GONE);
            textViewAdmin.setText("Reasons: \n" + user.get(position).getReasons());

            if(user.get(position).getReasons() == null)
            {
                textViewAdmin.setText("Reasons: None Specified");
            }

            textViewBanned.setVisibility(View.GONE);
            textViewComment.setVisibility(View.GONE);


        }

        if(user.get(position).getType() == 2)
        {
            buttonAdmin.setText("Remove Admin");
            buttonBanned.setVisibility(View.GONE);
            buttonComment.setVisibility(View.GONE);
            textViewAdmin.setVisibility(View.GONE);
            textViewBanned.setVisibility(View.GONE);
            textViewComment.setVisibility(View.GONE);
        }



        textViewName.setText("Username: " + user.get(position).getUser());
        textViewDesc.setText("UserID: " + user.get(position).getUserid());


        // getting movie data for the row
        User m = user.get(position);






        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method takes the data of a specific Item that buttonView represents and sends info to the InfoPage to be displayed to the user
             * @param convertView the current view
             *  @author Caelan Herzberg
             */
            public void onClick(View convertView) {
                String lol = "data";


                if(user.get(position).getType() == 2)
                {

                    JSONObject admin = new JSONObject();
                    try {
                        admin.put("admin_id",user.get(position).getId());

                        admin.put("userid",user.get(position).getUserid());
                        admin.put("user",user.get(position).getUser());




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    deleteUserJSON("", "http://coms-309-018.class.las.iastate.edu:8080/Admin/delete/" + user.get(position).getId(), admin);
                    activity.startActivity(i);
                }
                else
                {
                    /*
                    JSONObject a = new JSONObject();
                    try {
                        a.put("id", user.get(position).getId());
                        a.put("username", user.get(position).getUser());
                        a.put("password", user.get(position).getPassword());
                        a.put("email", user.get(position).getEmail());
                        a.put("pic", user.get(position).getPic());
                        a.put("gender", user.get(position).getGender());
                        a.put("userid", user.get(position).getUserid());
                        a.put("banned", user.get(position).getBanned());
                        a.put("comment", user.get(position).getIsComment());



                            a.put("admin", "true");
                            postUserJSON("",a, "http://coms-309-018.class.las.iastate.edu:8080/User/register");

                     */
                            postUserJSON("",null, "http://coms-309-018.class.las.iastate.edu:8080/Admin/register/" + user.get(position).getUserid());


/*
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

 */






                    activity.startActivity(i);
                }
                }






        });

        buttonBanned.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method takes the data of a specific Item that buttonView represents and sends info to the InfoPage to be displayed to the user
             * @param convertView the current view
             *  @author Caelan Herzberg
             */
            public void onClick(View convertView) {
                String lol = "data";

                if(user.get(position).getType() == 3)
                {

                    String x = user.get(position).getId();

                    JSONObject banned = new JSONObject();
                    try {
                        banned.put("id",user.get(position).getId());
                        banned.put("user",user.get(position).getUser());
                        banned.put("userid",user.get(position).getUserid());


                            banned.put("reasons", user.get(position).getReasons());


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    deleteUserJSON("", "http://coms-309-018.class.las.iastate.edu:8080/BanUser/delete/" + user.get(position).getId(), banned);
                    activity.startActivity(i);
                }
                else
                {

                        b.putExtra("id",user.get(position).getId());
                        b.putExtra("password",user.get(position).getPassword());
                        b.putExtra("email",user.get(position).getEmail());
                        b.putExtra("pic",user.get(position).getPic());
                        b.putExtra("gender",user.get(position).getGender());
                        b.putExtra("userid",user.get(position).getUserid());
                        b.putExtra("user",user.get(position).getUser());

                        activity.startActivity(b);

                }










            }
        });

        buttonComment.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method takes the data of a specific Item that buttonView represents and sends info to the InfoPage to be displayed to the user
             * @param convertView the current view
             *  @author Caelan Herzberg
             */
            public void onClick(View convertView) {



                JSONObject a = new JSONObject();
                try {
                    a.put("id", user.get(position).getId());
                    a.put("username", user.get(position).getUser());
                    a.put("password", user.get(position).getPassword());
                    a.put("email", user.get(position).getEmail());
                    a.put("pic", user.get(position).getPic());
                    a.put("gender", user.get(position).getGender());
                    a.put("userid", user.get(position).getUserid());

                    if(user.get(position).getIsComment().equals("true"))
                    {
                        a.put("isComment", "false");
                    }
                    else
                    {
                        a.put("comment", "true");
                    }

                    a.put("banned", user.get(position).getBanned());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                postUserJSON("",a, "http://coms-309-018.class.las.iastate.edu:8080/User/register");


                activity.startActivity(i);

            }
        });

        return convertView;
    }


}