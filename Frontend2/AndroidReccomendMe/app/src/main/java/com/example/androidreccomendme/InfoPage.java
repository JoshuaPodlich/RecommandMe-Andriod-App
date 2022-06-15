package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.androidreccomendme.utils.ServerMethods.*;
import static com.example.androidreccomendme.utils.URL_Processor.*;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The InfoPage class handles the process of displaying a specific Item's information to the user and providing buttons to access CommentPage and VideoPage
 * @author  Caelan Herzberg
 */
public class InfoPage extends AppCompatActivity {
    private String id,name,description,score,platform,picture,time_length,director,date,country_of_origin,language,url,author,ISBN10,ISBN13,place,code,address,priceRange,phoneNum,star,episode,language_subtitle,genre,PG_level,ms_hour,producer,pages,ageLimit,publisher,price,category;

    @Override
    /**
     * The onCreate method creates the activity and inflates UI elements that display an Item's information using data sourced from the CategoryPage activity
     * @param savedInstanceState current Bundle
     * @author Caelan Herzberg
     */
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
       SharedPreferences.Editor editor = mSharedPreference.edit();
        String isSearch=(mSharedPreference.getString("search", "Default_Value"));



        String TAG = InfoPage.class.getSimpleName();
       // makeJsonObjReqSearch(TAG, "1", prefs);
       // makeJsonObjReq(TAG,"http://coms-309-018.class.las.iastate.edu:8080/Movie/info/1");



        if (isSearch.equals("0"))
        {

            Intent intent = getIntent();
           // id = intent.getStringExtra("theID");
            name = intent.getStringExtra("theName");
            description = intent.getStringExtra("theDescription");
            score = intent.getStringExtra("theScore");
            platform = intent.getStringExtra("thePlatform");
            picture = intent.getStringExtra("thePic");
            time_length = intent.getStringExtra("theTime_length");
            director = intent.getStringExtra("theDirector");
            date = intent.getStringExtra("theDate");
            country_of_origin = intent.getStringExtra("theCountry_of_origin");
            language = intent.getStringExtra("theLanguage");
            url = intent.getStringExtra("theURL");
            author = intent.getStringExtra("theAuthor");
            ISBN10 = intent.getStringExtra("theISBN10");
            ISBN13 = intent.getStringExtra("theISBN13");
            place = intent.getStringExtra("thePlace");
            code = intent.getStringExtra("theCode");
            address = intent.getStringExtra("theAddress");
            priceRange = intent.getStringExtra("thePriceRange");
            phoneNum = intent.getStringExtra("thePhoneNumber");
            star = intent.getStringExtra("theStar");
            episode = intent.getStringExtra("theEpisode");
            language_subtitle = intent.getStringExtra("theLanguage_subtitle");
            genre = intent.getStringExtra("theGenre");
            PG_level = intent.getStringExtra("thePG_level");
            ms_hour = intent.getStringExtra("theMs_hour");
            ageLimit = intent.getStringExtra("theAgeLimit");
            producer = intent.getStringExtra("theProducer");
            publisher = intent.getStringExtra("thePublisher");
            price = intent.getStringExtra("thePrice");
            category = intent.getStringExtra("theCategory");
            pages = intent.getStringExtra("thePages");

        }
        else
        {

            editor.putString("search", "0");

            name = (mSharedPreference.getString("theName", "Default_Value"));
            description = (mSharedPreference.getString("theDescription", "Default_Value"));

            score = (mSharedPreference.getString("theScore", "Default_Value"));
            platform = (mSharedPreference.getString("thePlatform", "Default_Value"));
            picture = (mSharedPreference.getString("thePic", "Default_Value"));
            time_length = (mSharedPreference.getString("theTime_length", "Default_Value"));
            director = (mSharedPreference.getString("theDirector", "Default_Value"));
            date = (mSharedPreference.getString("theDate", "Default_Value"));
            country_of_origin = (mSharedPreference.getString("theCountry_of_origin", "Default_Value"));
            language = (mSharedPreference.getString("theLanguage", "Default_Value"));
            url = (mSharedPreference.getString("theURL", "Default_Value"));
            author = (mSharedPreference.getString("theAuthor", "Default_Value"));
            ISBN10 = (mSharedPreference.getString("theISBN10", "Default_Value"));
            ISBN13 = (mSharedPreference.getString("theISBN13", "Default_Value"));
            place = (mSharedPreference.getString("thePlace", "Default_Value"));
            code = (mSharedPreference.getString("theCode", "Default_Value"));
            address = (mSharedPreference.getString("theAddress", "Default_Value"));
            priceRange = (mSharedPreference.getString("thePriceRange", "Default_Value"));
            phoneNum = (mSharedPreference.getString("thePhoneNum", "Default_Value"));
            star = (mSharedPreference.getString("theStar", "Default_Value"));
            episode = (mSharedPreference.getString("theEpisode", "Default_Value"));
            language_subtitle = (mSharedPreference.getString("theLanguage_subtitle", "Default_Value"));
            genre = (mSharedPreference.getString("theGenre", "Default_Value"));
            PG_level = (mSharedPreference.getString("thePG_level", "Default_Value"));
            ms_hour = (mSharedPreference.getString("theMs_hour", "Default_Value"));
            ageLimit = (mSharedPreference.getString("theAgeLimit", "Default_Value"));
            producer = (mSharedPreference.getString("theProducer", "Default_Value"));
            publisher = (mSharedPreference.getString("thePublisher", "Default_Value"));
            price = (mSharedPreference.getString("thePrice", "Default_Value"));
            category = (mSharedPreference.getString("theCategory", "Default_Value"));
            pages = (mSharedPreference.getString("thePages", "Default_Value"));

        }

        Intent video = new Intent(this, VideoPage.class);
        Intent comment = new Intent(this,CommentPage.class);
        Intent home = new Intent(this,MainMenu.class);
        Intent Profile = new Intent(this,ProfilePage.class);
        Intent Login = new Intent(this,LoginPage.class);

        String commentCategory = "";





        if(url != null)
        {
            video.putExtra("theVideo",url.toString());
        }


        TextView InfoTitle = (TextView) findViewById(R.id.InfoTitle);
        TextView InfoDescription = (TextView) findViewById(R.id.InfoDescription);
        TextView InfoMain1 = (TextView) findViewById(R.id.InfoMainText1);
        TextView InfoMain2 = (TextView) findViewById(R.id.InfoMainText2);
        TextView InfoMain3 = (TextView) findViewById(R.id.InfoMainText3);
        TextView InfoMain4 = (TextView) findViewById(R.id.InfoMainText4);
        TextView InfoExtra1 = (TextView) findViewById(R.id.InfoExtra1);
        TextView InfoExtra2 = (TextView) findViewById(R.id.InfoExtra2);
        TextView InfoExtra3 = (TextView) findViewById(R.id.InfoExtra3);
        TextView InfoExtra4 = (TextView) findViewById(R.id.InfoExtra4);
        TextView InfoExtra5 = (TextView) findViewById(R.id.InfoExtra5);
        TextView InfoExtra6 = (TextView) findViewById(R.id.InfoExtra6);
        Button CommentButton = (Button) findViewById(R.id.InfoBtn1);
        Button VideoButton = (Button) findViewById(R.id.InfoBtn2);
        ImageView MyImage = (ImageView) findViewById(R.id.InfoPic);
        Button HomeButton = (Button) findViewById(R.id.btnHomeInfo);
        Button LoginButton = (Button) findViewById(R.id.btnLogInfo);
        Button ProfileButton = (Button) findViewById(R.id.btnProfileInfo);





        String picUrl = Unpack(picture);
        picUrl = picUrl + ".jpeg";

        //url = "https://i.imgur.com/qhkCTrB.jcpeg";

        // In the initializeView method


// In the onClick method

        Picasso.get().load(picUrl).into(MyImage);


        String finalUrl = url;
        VideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method uses an intent in order to start another activity
             * @param convertView current view
             * @author Caelan Herzberg
             */
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                if(url != null)
                {
                    video.putExtra("URL", finalUrl);
                    startActivity(video);
                }




            }
        });

        CommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * The onClick method uses an intent in order to start another activity
             * @param convertView current view
             * @author josh podlich
             */
            public void onClick(View convertView) {
                // context.startActivity(ProfilePage.class);
                startActivity(comment);


            }
        });



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

        InfoTitle.setText(name);
        InfoDescription.setText(description);




        if(category.equals("movie"))
        {
            date = "Date: \n" + date;
            InfoMain1.setText(date);
            platform = "Platform: \n" + platform;
            InfoMain2.setText(platform);
            score = "Score: \n" + score;
            InfoMain3.setText(score);
            genre = "Genre: \n" + genre;
            InfoMain4.setText("");

            time_length = "Runtime: \n"+ time_length;
            InfoExtra1.setText(time_length);
            director = "Director: \n" + director;
            InfoExtra2.setText(director);
            language = "Language: \n" + language;
            InfoExtra3.setText(language);
            country_of_origin = "Country of Origin: \n" + country_of_origin;
            InfoExtra4.setText(country_of_origin);
            InfoExtra5.setText(genre);
            InfoExtra6.setText("");

            commentCategory = "Movie";

        }
        if(category.equals("books"))
        {
            author = "Author: \n" + author;
            InfoMain1.setText(author);
            platform = "Price: \n" + price;
            InfoMain2.setText("Price: \n" + price);
            score = "Score: \n" + score;
            InfoMain3.setText(score);
            pages = "Pages: \n" + pages;
            InfoMain4.setText("");

            price = "Pages: \n" + pages;
            InfoExtra1.setText(pages);
            ISBN10 = "ISBN10: \n" + ISBN10;
            InfoExtra2.setText(ISBN10);
            ISBN13 = "ISBN13: \n" + ISBN13;
            InfoExtra3.setText(ISBN13);
            language = "Language: \n" + language;
            InfoExtra4.setText(language);
            publisher = "Publisher: \n" + publisher;
            InfoExtra5.setText(publisher);
            date = "Date: \n" + date;
            InfoExtra6.setText(date);

            commentCategory = "Book";

            VideoButton.setVisibility(View.GONE);

        }
        if(category.equals("restaurant"))
        {

            address = "Address: \n" + address;
            InfoMain1.setText(address);
            phoneNum = "Phone: \n" + phoneNum;
            InfoMain2.setText(phoneNum);
            score = "Score: \n" + score;
            InfoMain3.setText("");
            priceRange = "Price Range: \n" + priceRange;
            InfoMain4.setText("");

            InfoExtra1.setText(score);
            InfoExtra2.setText(priceRange);
            InfoExtra3.setText("");
            InfoExtra4.setText("");
            InfoExtra5.setText("");
            InfoExtra6.setText("");
            VideoButton.setVisibility(View.GONE);

            commentCategory = "Restaurant";

        }
        if(category.equals("tv"))
        {

            InfoMain1.setText("PG: \n" + PG_level);
            InfoMain2.setText("Platform: \n" + platform);
            InfoMain4.setText("");
            InfoMain3.setText("Genre: \n" + genre);

            InfoExtra1.setText("Episodes: \n" + episode);
           // InfoExtra2.setText("Director: \n" + director);
            InfoExtra3.setText("Subtitle: \n" + language_subtitle);
         //   InfoExtra4.setText("Made in: \nThe " + country_of_origin);
            InfoExtra5.setText("Stars: \n" + star);
            InfoExtra6.setText("Score: \n" + score);

            commentCategory = "TVShow";

        }

        if(category.equals("videogames"))
        {

            InfoMain1.setText("Price: \n$" + price);
            InfoMain2.setText("Platform: \n" +  platform);
            InfoMain3.setText("Score: \n" + score);
            InfoMain4.setText("");

            InfoExtra1.setText("Main Story Hours: \n" + ms_hour);
            InfoExtra2.setText("Date: \n" + date);
            InfoExtra3.setText("Publisher: \n" + publisher);
            InfoExtra4.setText("Producer: \n" + producer);
            InfoExtra5.setText("Genre: \n" + genre);
            InfoExtra6.setText("AgeLimit: \n" + ageLimit);

            commentCategory = "VideoGame";

        }

        comment.putExtra("name", name);
        comment.putExtra("category", commentCategory);

    }
}