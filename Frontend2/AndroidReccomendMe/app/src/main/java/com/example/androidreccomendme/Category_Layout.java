package com.example.androidreccomendme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;

/**
 * The Category_Layout class is used to create the list elements used to display Items
 * @author  Caelan Herzberg
 */
public class Category_Layout extends AppCompatActivity {

    @Override
    /**
     * The onCreate method creates the Category_Layout activity
     * @param savedInstanceState current Bundle
     * @author Caelan Herzberg
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_layout);
    }
}