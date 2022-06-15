package com.example.androidreccomendme.utils;

import java.util.ArrayList;

public class URL_Processor {


    public static String Process(String url){


        ArrayList<String> a = new ArrayList<String>();
        String temp = "";

        for ( int i = 0; i < url.length(); i++ ) {


            if(url.charAt(i) == '/')
            {
                temp = temp + "\\";
                temp = temp + url.charAt(i);
            }
            else
            {
                temp = temp + url.charAt(i);
            }

           // a.add(url.charAt(i));


        }


        return temp;
    }

    public static String Unpack(String url){


        ArrayList<String> a = new ArrayList<String>();
        String temp = "";

        for ( int i = 0; i < url.length(); i++ ) {


            if(url.charAt(i) == '\\')
            {

            }
            else
            {
                temp = temp + url.charAt(i);
            }

            // a.add(url.charAt(i));


        }


        return temp;
    }



}
