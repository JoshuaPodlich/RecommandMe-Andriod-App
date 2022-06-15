package com.example.androidreccomendme.utils;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.util.Log;
import android.content.SharedPreferences;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.androidreccomendme.Comment;
import com.example.androidreccomendme.CommentLayout;
import com.example.androidreccomendme.CommentList;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidreccomendme.CategoryPage;
import com.example.androidreccomendme.InfoPage;
import com.example.androidreccomendme.Item;
import com.example.androidreccomendme.ItemList;
import com.example.androidreccomendme.LoginPage;
import com.example.androidreccomendme.MainMenu;
import com.example.androidreccomendme.User;
import com.example.androidreccomendme.UserList;
import com.example.androidreccomendme.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The ServerMethods class holds methods for JSON requests to be used in other classes.
 * @author  Caelan Herzberg
 */
public class ServerMethods {

    public static void requestCommentJson(String url, String tag_json_arry, String TAG, List<Comment> list, CommentList adapter)
    {
        JsonArrayRequest req = new JsonArrayRequest(url,

                new Response.Listener<JSONArray>() {
                    @Override
                    /**
                     * The onResponse method uses the response from the server and parses it
                     * @param response the array of Items from the server.
                     * @author Josh Podlich
                     */
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        for(int n = 0; n < response.length(); n++)
                        {
                            try {
                                JSONObject comment = response.getJSONObject(n);

                                Comment com = new Comment();

                                com.setName(comment.optJSONObject("user").getString("username"));
                                com.setReview(comment.getString("reviewText"));
                                com.setVote(false);

                                list.add(com);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        adapter.notifyDataSetChanged();

                    }

                }, new Response.ErrorListener() {
            @Override
            /**
             * The onErrorResponse method posts an error log noting the error message
             * @param error the VolleyError object containing an error message
             * @author Caelan Herzberg
             */
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        req.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(req,
                tag_json_arry);
    }

    /**
     * The requestCategoryJson method performs a JSON Array GET request and creates a list of Items
     * Receives an array of JSON objects representing Items, creates Item objects with the data from the JSON objects, and then adds the Item objects to the CategoryPage list.
     *
     * @param url           is a string containing the url to request data from
     * @param tag_json_arry is a tag that can be used to cancel volley request
     * @param type          is a String that specifies what type of Item this request contains that is stored in the Item object
     * @param TAG           is a string used to cancel volley requests
     * @param infoType      is an integer used to decide which item type is being filled.
     * @param list          is a List of items that objects will be stored in.
     * @param adapter       is an ItemList adapter used to determine list layout and to update the list when changes are made.
     * @author Caelan Herzberg
     */
    public static void requestCategoryJson(String url, String tag_json_arry, String type, String TAG, int infoType, List<Item> list, ItemList adapter) {
        JsonArrayRequest req = new JsonArrayRequest(url,

                new Response.Listener<JSONArray>() {
                    @Override
                    /**
                     * The onResponse method uses the response from the server and parses it
                     * @param response the array of Items from the server.
                     * @author Caelan Herzberg
                     */
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        int index = 0;
                        for (int n = 0; n < response.length(); n++) {
                            try {
                                JSONObject item = response.getJSONObject(n);
                                //movieJSONList.add(movie);
                                Item cat = new Item();
                                cat.setType(infoType);
                                cat.setCategory(type);

                                //movie case
                                if (infoType == 1) {

                                    cat.setName(item.getString("name"));
                                    cat.setDescription(item.getString("description"));
                                    cat.setScore(item.getString("score"));
                                    cat.setPlatform(item.getString("platform"));
                                    cat.setPic(item.getString("pic"));
                                    cat.setTime_length(item.getString("time_length"));
                                    cat.setDirector(item.getString("director"));
                                    cat.setDate(item.getString("release_date"));
                                    cat.setCountry_of_origin(item.getString("country_of_origin"));
                                    cat.setLanguage(item.getString("language"));
                                    cat.setGenre(item.getString("types"));
                                    cat.setUrl(item.getString("url"));

                                }

                                //book case
                                if (infoType == 2) {

                                    cat.setID(item.getString("book_id"));
                                    cat.setName(item.getString("name"));
                                    cat.setDescription(item.getString("description"));
                                    cat.setDate(item.getString("release_date"));
                                    cat.setAuthor(item.getString("author"));
                                    cat.setPic(item.getString("pic"));
                               //     cat.setUrl(item.getString("url"));
                                    cat.setScore(item.getString("score"));
                                    cat.setISBN10(item.getString("isbn_10"));
                                    cat.setISBN10(item.getString("isbn_13"));
                                    cat.setPlace(item.getString("place"));
                                    cat.setPages(item.getString("pages"));
                                    cat.setPrice(item.getString("price"));

                                }
                                //Resturaunt
                                if (infoType == 3) {

                                    cat.setID(item.getString("id"));
                                    cat.setName(item.getString("name"));
                                    cat.setDescription(item.getString("description"));
                                   // cat.setCode(item.getString("code"));
                                    // cat.setDate(item.getString("date"));
                                    cat.setPhoneNum(item.getString("phoneNum"));
                                    cat.setAddress(item.getString("address"));
                                    cat.setPic(item.getString("pic"));
                                  //  cat.setUrl(item.getString("url"));
                                    cat.setPriceRange(item.getString("priceRange"));
                                    cat.setScore(item.getString("score"));
                                }
                                //tv case
                                if (infoType == 4) {

                                    cat.setID(item.getString("id"));
                                    cat.setName(item.getString("name"));
                                    cat.setDescription(item.getString("description"));
                                    cat.setPlatform(item.getString("platform"));
                                    cat.setPic(item.getString("pic"));
                                    cat.setUrl(item.getString("url"));
                                    cat.setEpisode(item.getString("episodes"));
                                    cat.setStar(item.getString("stars"));
                                    cat.setScore(item.getString("score"));
                                    cat.setLanguage_subtitle(item.getString("language_Subtitle"));
                                    cat.setGenre(item.getString("type"));
                                    cat.setPG_level(item.getString("pg_level"));

                                }

                                if (infoType == 5) {
                                    cat.setID(item.getString("id"));
                                    cat.setName(item.getString("name"));
                                    cat.setDescription(item.getString("description"));
                                    cat.setPlatform(item.getString("platform"));
                                    cat.setDate(item.getString("release_date"));
                                    cat.setPic(item.getString("pic"));
                                    cat.setUrl(item.getString("url"));
                                    cat.setMs_hour(item.getString("ms_hour"));
                                    cat.setAgeLimit(item.getString("ageLimit"));
                                    cat.setScore(item.getString("score"));
                                    cat.setGenre(item.getString("type"));
                                    cat.setPrice(item.getString("price"));
                                    cat.setPublisher(item.getString("publisher"));
                                    cat.setProducer(item.getString("producer"));


                                }

                                list.add(cat);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        adapter.notifyDataSetChanged();




                    }

                }, new Response.ErrorListener() {
            @Override
            /**
             * The onErrorResponse method posts an error log noting the error message
             * @param error the VolleyError object containing an error message
             * @author Caelan Herzberg
             */
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue

        req.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(req,
                tag_json_arry);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_arry);
    }


    public static void makeJsonObjReq(String TAG, String url) {
        JSONObject a = new JSONObject();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, a,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        JSONObject a = response;
                        String po = "dd";


                        // msgResponse.setText(response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }

        });

        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(jsonObjReq,
                TAG);



    }

    public static void postCommentJSON(String url, String TAG, JSONObject comment, JSONObject user) {

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, comment,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        try{
                            response.put("user", user);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }

        });






        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(jsonObjReq,
                TAG);

    }


    public static void getUserInfo(String url, String username, String password, String TAG, JSONObject comment, String commentURL)
    {
        //url = url + username;
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());


                        try {
                            postCommentJSON(commentURL, "create-comment", comment, response);
                            response.put("comment", true);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                }, new Response.ErrorListener() {
            @Override
            /**
             * The onErrorResponse method posts an error log noting the error message
             * @param error the VolleyError object containing an error message
             * @author Caelan Herzberg
             */
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        req.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(req,
                TAG);
    }



    public static void postUserJSON(String TAG, JSONObject user, String url) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, user,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());



                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }

        });










        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(jsonObjReq,
                TAG);

    }





    public static void deleteUserJSON(String TAG,String url, JSONObject user) {



        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.DELETE,
                url, user,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        });
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));
        AppController.getInstance().addToRequestQueue(jsonObjReq,
                TAG);
    }


    public static void loginUser(String URLcheck, SharedPreferences.Editor edit, String username, String password, String TAG)
    {
        URLcheck = URLcheck + username + "/" + password;
        //URLcheck = URLcheck + username;

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                URLcheck, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());


                            try {
                                edit.putString("banned", response.getString("banned"));
                                if(!response.getBoolean("banned")) {
                                    edit.putString("id", response.getString("id"));
                                    edit.putString("username", response.getString("username"));
                                    edit.putString("password", response.getString("password"));
                                    edit.putString("email", response.getString("email"));
                                    edit.putString("pic", response.getString("pic"));
                                    edit.putString("gender", response.getString("gender"));
                                    edit.putString("userid", response.getString("userID"));

                                    edit.putString("isComment", response.getString("comment"));
                                    edit.putString("admin",response.getString("admin"));
                                    edit.commit();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                    }

                }, new Response.ErrorListener() {
            @Override
            /**
             * The onErrorResponse method posts an error log noting the error message
             * @param error the VolleyError object containing an error message
             * @author Caelan Herzberg
             */
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        req.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(req,
                TAG);

    }



    public static void makeJsonObjReqSearch(String TAG, String query, SharedPreferences prefs) {
        //Intent i = new Intent(CategoryPage.this, InfoPage.class);
        //startActivity(i);



       final SharedPreferences.Editor editor = prefs.edit();
        editor.putString("success", "0");
        editor.commit();



        JSONObject a = new JSONObject();
        JsonObjectRequest movieQuery = new JsonObjectRequest(Request.Method.GET,
                "http://coms-309-018.class.las.iastate.edu:8080/Movie/get/" + query, a,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject movie) {
                        Log.d(TAG, movie.toString());

                        JSONObject thisMovie = movie;
                        try {




                            /*
                            i.putExtra("theName",thisMovie.getString("name"));
                            i.putExtra("theDescription",thisMovie.getString("description"));
                            i.putExtra("theScore", thisMovie.getString("score"));
                            i.putExtra("thePlatform", thisMovie.getString("platform"));
                             i.putExtra("thePic", thisMovie.getString("pic"));
                            i.putExtra("theTime_length", thisMovie.getString("time_length"));
                            i.putExtra("theDirector", thisMovie.getString("director"));
                            i.putExtra("theDate",thisMovie.getString("release_date"));
                            i.putExtra("theCountry_of_origin", thisMovie.getString("country_of_origin"));
                            i.putExtra("theLanguage", thisMovie.getString("language"));
                            i.putExtra("theURL", thisMovie.getString("url"));
                            i.putExtra("theGenre", thisMovie.getString("types"));
                              i.putExtra("theCategory", "1");
                              */


                            editor.putString("theName", thisMovie.getString("name"));
                            editor.putString("theDescription", thisMovie.getString("description"));
                            editor.putString("theScore", thisMovie.getString("score"));
                            editor.putString("thePlatform", thisMovie.getString("platform"));
                            editor.putString("thePic", thisMovie.getString("pic"));
                            editor.putString("theTime_length", thisMovie.getString("time_length"));
                            editor.putString("theDirector", thisMovie.getString("director"));
                            editor.putString("theDate", thisMovie.getString("release_date"));
                            editor.putString("theLanguage", thisMovie.getString("language"));
                            editor.putString("theUrl", thisMovie.getString("url"));
                            editor.putString("theGenre", thisMovie.getString("types"));
                            editor.putString("theCategory", "movie");
                            editor.putString("search", "1");
                            editor.putString("success", "1");
                            editor.commit();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        // msgResponse.setText(response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }

        });

        movieQuery.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(movieQuery,
                TAG);

        JsonObjectRequest bookQuery = new JsonObjectRequest(Request.Method.GET,
                "http://coms-309-018.class.las.iastate.edu:8080/Book/get/" + query, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject book) {
                        Log.d(TAG, book.toString());

                        JSONObject thisBook = book;


                        try {


/*
                            i.putExtra("theName",thisBook.getString("name"));
                            i.putExtra("theDescription",thisBook.getString("description"));
                            i.putExtra("theScore", thisBook.getString("score"));
                            i.putExtra("thePic", thisBook.getString("pic"));
                            i.putExtra("theDate",thisBook.getString("release_date"));
                            i.putExtra("theLanguage", thisBook.getString("language"));
                            i.putExtra("theAuthor", thisBook.getString("author"));
                            i.putExtra("theISBN10", thisBook.getString("isbn_10"));
                            i.putExtra("theISBN13", thisBook.getString("isbn_13"));
                            i.putExtra("thePrice", thisBook.getString("price"));
                            i.putExtra("thePages", thisBook.getString("pages"));
                            i.putExtra("theCategory", "2");
*/
                            editor.putString("theName", thisBook.getString("name"));
                            editor.putString("theDescription", thisBook.getString("description"));
                            editor.putString("theScore", thisBook.getString("score"));
                            editor.putString("thePic", thisBook.getString("pic"));
                            editor.putString("theDate", thisBook.getString("release_date"));
                            editor.putString("theLanguage", thisBook.getString("language"));
                            editor.putString("theAuthor", thisBook.getString("author"));
                            editor.putString("theISBN10", thisBook.getString("isbn_10"));
                            editor.putString("theISBN13", thisBook.getString("isbn_13"));
                            editor.putString("thePrice", thisBook.getString("price"));
                            editor.putString("thePages", thisBook.getString("price"));
                            editor.putString("theCategory", "book");
                            editor.putString("search", "1");
                            editor.putString("success", "1");

                            editor.commit();



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                        // msgResponse.setText(response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }

        });

        bookQuery.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(bookQuery,
                TAG);


        JsonObjectRequest TVShowQuery = new JsonObjectRequest(Request.Method.GET,
                "http://coms-309-018.class.las.iastate.edu:8080/TVShow/get/" + query, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject show) {
                        Log.d(TAG, show.toString());

                        JSONObject thisShow = show;


                        try {


/*
                            i.putExtra("theName",thisShow.getString("name"));
                            i.putExtra("theDescription",thisShow.getString("description"));
                            i.putExtra("theScore", thisShow.getString("score"));
                            i.putExtra("thePlatform", thisShow.getString("platform"));
                            i.putExtra("theDirector", thisShow.getString("director"));
                            i.putExtra("theCountry_of_origin", thisShow.getString("country_of_origin"));
                            i.putExtra("theStar", thisShow.getString("stars"));
                            i.putExtra("theEpisode", thisShow.getString("episodes"));
                            i.putExtra("theLanguage_subtitle", thisShow.getString("language_Subtitle"));
                            i.putExtra("theGenre", thisShow.getString("types"));
                            i.putExtra("thePG_level", thisShow.getString("pg_level"));
                            i.putExtra("theCategory", "4");

 */

                            editor.putString("theName", thisShow.getString("name"));
                            editor.putString("theDescription", thisShow.getString("description"));
                            editor.putString("theScore", thisShow.getString("score"));
                            editor.putString("thePlatform", thisShow.getString("platform"));
                            editor.putString("thePic", thisShow.getString("pic"));
                       //     editor.putString("theDirector", thisShow.getString("director"));
                           // editor.putString("theCountry_of_origin", thisShow.getString("country_of_origin"));
                            editor.putString("theStar", thisShow.getString("stars"));
                            editor.putString("theEpisode", thisShow.getString("episodes"));
                            editor.putString("theLanguage_subtitle", thisShow.getString("language_Subtitle"));
                            editor.putString("theGenre", thisShow.getString("type"));
                            editor.putString("thePG_level", thisShow.getString("pg_level"));
                            editor.putString("theUrl", thisShow.getString("url"));
                            editor.putString("theCategory", "tv");
                            editor.putString("search", "1");
                            editor.putString("success", "1");

                            editor.commit();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        // msgResponse.setText(response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }

        });

        TVShowQuery.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(TVShowQuery,
                TAG);


        JsonObjectRequest vgQuery = new JsonObjectRequest(Request.Method.GET,
                "http://coms-309-018.class.las.iastate.edu:8080/VideoGame/get/" + query, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject vg) {
                        Log.d(TAG, vg.toString());

                        JSONObject thisVg = vg;



                        try {
                            /*
                            i.putExtra("theName",thisVg.getString("name"));
                            i.putExtra("theDescription",thisVg.getString("description"));
                            i.putExtra("theScore", thisVg.getString("score"));
                            i.putExtra("thePlatform", thisVg.getString("platform"));
                            i.putExtra("thePic", thisVg.getString("pic"));
                            i.putExtra("theDate",thisVg.getString("release_date"));
                            i.putExtra("theGenre", thisVg.getString("types"));
                            i.putExtra("theMs_hour", thisVg.getString("ms_hour"));
                            i.putExtra("theAgeLimit", thisVg.getString("ageLimit"));
                            i.putExtra("theProducer", thisVg.getString("producer"));
                            i.putExtra("thePublisher", thisVg.getString("publisher"));
                            i.putExtra("thePrice", thisVg.getString("price"));
                            i.putExtra("theCategory", "5");

                             */



                            editor.putString("theName", thisVg.getString("name"));
                            editor.putString("theDescription", thisVg.getString("description"));
                            editor.putString("theScore", thisVg.getString("score"));
                            editor.putString("thePlatform", thisVg.getString("platform"));
                            editor.putString("thePic", thisVg.getString("pic"));
                           editor.putString("theDate", thisVg.getString("release_date"));
                            editor.putString("theGenre", thisVg.getString("type"));
                            editor.putString("theMs_hour", thisVg.getString("ms_hour"));
                            editor.putString("theAgeLimit", thisVg.getString("ageLimit"));
                            editor.putString("theProducer", thisVg.getString("producer"));
                            editor.putString("thePublisher", thisVg.getString("publisher"));
                            editor.putString("thePrice", thisVg.getString("price"));
                            editor.putString("theUrl", thisVg.getString("url"));

                            editor.putString("theCategory", "videogames");
                            editor.putString("search", "1");
                            editor.putString("success", "1");



                            editor.commit();
                            //editor.apply();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                        // msgResponse.setText(response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }

        });

        vgQuery.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(vgQuery,
                TAG);


        JsonObjectRequest restQuery = new JsonObjectRequest(Request.Method.GET,
                "http://coms-309-018.class.las.iastate.edu:8080/Restaurant/get/" + query, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject rest) {
                        Log.d(TAG, rest.toString());

                        JSONObject thisRest = rest;


                        try {


                            /*
                            i.putExtra("theName",thisRest.getString("name"));
                            i.putExtra("theDescription",thisRest.getString("description"));
                            i.putExtra("theScore", thisRest.getString("score"));
                            i.putExtra("thePic", thisRest.getString("pic"));
                             i.putExtra("theAddress", thisRest.getString("address"));
                            i.putExtra("thePriceRange", thisRest.getString("priceRange"));
                            i.putExtra("thePhoneNumber", thisRest.getString("phoneNum"));
                            i.putExtra("theCategory", "3");
                            */


                            editor.putString("theName", thisRest.getString("name"));
                            editor.putString("theDescription", thisRest.getString("description"));
                            editor.putString("theScore", thisRest.getString("score"));
                            editor.putString("thePic", thisRest.getString("pic"));
                            editor.putString("theAddress", thisRest.getString("address"));
                            editor.putString("thePriceRange", thisRest.getString("priceRange"));
                            editor.putString("thePhoneNum", thisRest.getString("phoneNum"));
                            editor.putString("theCategory", "restaurant");
                            editor.putString("search", "1");
                            editor.putString("success", "1");

                            editor.commit();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }





                        // msgResponse.setText(response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }

        });

        restQuery.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(restQuery,
                TAG);
        editor.apply();




    }




    public static void requestUsersJson(String url, String tag_json_arry, String type, String TAG, int infoType, List<User> list, UserList adapter, String myID) {


        JsonArrayRequest req = new JsonArrayRequest(url,

                new Response.Listener<JSONArray>() {
                    @Override
                    /**
                     * The onResponse method uses the response from the server and parses it
                     * @param response the array of Items from the server.
                     * @author Caelan Herzberg
                     */
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        int index = 0;
                        for (int n = 0; n < response.length(); n++) {
                            try {
                                JSONObject user = response.getJSONObject(n);
                                //movieJSONList.add(movie);

                                User u = new User();
                                u.setType(infoType);
                                u.setCategory(type);

                                //User case
                                if (infoType == 1) {

                                    u.setId(user.getString("id"));
                                    u.setUser(user.getString("username"));
                                    u.setPassword(user.getString("password"));
                                    u.setEmail(user.getString("email"));
                                    u.setPic(user.getString("pic"));
                                    u.setGender(user.getString("gender"));
                                    u.setUserid(user.getString("userID"));
                                    u.setBanned(user.getString("banned"));
                                    u.setIsComment(user.getString("comment"));
                                    u.setAdmin(user.getString("admin"));

/*
                                    if(u.getUserid().equals(myID) /*|| u.getBanned().equals("true") || u.getAdmin().equals("true"))
                                    {

                                    }
                                    else
                                    {

                                    }
                                    */


                                    list.add(u);


                                }

                                //Admin case
                                if (infoType == 2) {



                                    JSONObject a = new JSONObject(user.getString("user"));

                                    u.setUserid(a.getString("userID"));
                                    u.setUser(a.getString("username"));
                                    u.setId(user.getString("admin_id"));




                                    u.setPassword(a.getString("password"));
                                    u.setEmail(a.getString("email"));
                                    u.setPic(a.getString("pic"));
                                    u.setGender(a.getString("gender"));
                                    u.setUserid(a.getString("userID"));
                                    u.setBanned(a.getString("banned"));
                                    u.setIsComment(a.getString("comment"));
                                    u.setAdmin(a.getString("admin"));




                                    if(u.getUserid().equals(myID) )
                                    {

                                    }
                                    else
                                    {
                                        list.add(u);
                                    }



                                }
                                //Banned Case
                                if (infoType == 3) {




                                  //  u.setUserid(user.getString("id"));
                                    JSONObject a = new JSONObject(user.getString("user"));

                                    u.setUser(a.getString("username"));
                                    u.setUserid(user.getString("userid"));
                                    u.setId(user.getString("id"));

                                    u.setPassword(a.getString("password"));
                                    u.setEmail(a.getString("email"));
                                    u.setPic(a.getString("pic"));
                                    u.setGender(a.getString("gender"));

                                    u.setBanned(a.getString("banned"));
                                    u.setIsComment(a.getString("comment"));
                                    u.setAdmin(a.getString("admin"));
                                   u.setReasons(user.getString("reasons"));

                                    if(u.getUserid().equals(myID) )
                                    {

                                    }
                                    else
                                    {
                                        list.add(u);
                                    }


                                }





                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        adapter.notifyDataSetChanged();




                    }

                }, new Response.ErrorListener() {
            @Override
            /**
             * The onErrorResponse method posts an error log noting the error message
             * @param error the VolleyError object containing an error message
             * @author Caelan Herzberg
             */
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue

        req.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        AppController.getInstance().addToRequestQueue(req,
                tag_json_arry);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_arry);
    }




}