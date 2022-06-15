package com.example.androidreccomendme;

import java.util.ArrayList;
import android.content.SharedPreferences;

/**
 * The Item class represents all the data that comprises an item with respective getters and setters.
 * @author  Caelan Herzberg
 */
public class Item {

    //type is an int value 1-5 that represents what type of Item an Item is
    private int type;
    // category is a String value that represents an Item's category
    private String category;
    //id is a String value that represents an Item's id
    private String id;
    //name is a String value that represents an Item's name
    private String name;
    //description is a String value that represents an Item's description
    private String description;
    //score is a String value that represents an Item's score
    private String score;
    //platform is a String value that represents an Item's platform(theater/hulu/...etc)
    private String platform;
    //pic is a String value that contains a URL linking to an Item's corresponding picture
    private String pic;
    //time_length is a String value that represents an Item's runtime
    private String time_length;
    //director is a String value that represents an Item's director
    private String director;
    //release_date is a String value that represents an Item's release data
    private String release_date;
    //country_of_origin is a String value that represents an Item's country of origin
    private String country_of_origin;
    //language is a String value that represents an Item's language
    private String language;
    //url is a String value that represents an Item's url linking to it's respective video
    private String url;
    //author is a String value that represents an Item's author
    private String author;
    //ISBN_10 is a String value that represents an Item's ISBN_10 number
    private String ISBN_10;
    //ISBN_13 is a String value that represents an Item's ISBN_13 number
    private String ISBN_13;
    //place is a String value that represents an Item's location
    private String place;
    //code is a String value that represents an Item's code
    private String code;
    //address is a String value that represents an Item's address
    private String address;
    //priceRange is a String value that represents an Item's priceRange
    private String priceRange;
    //phoneNum is a String value that represents an Item's phone number
    private String phoneNum;
    //stars is a String value that represents an Item's stars out of 5
    private String stars;
    //episodes is a String value that represents an Item's number of episodes
    private String episodes;
    //language_subtitle is a String value that represents an Item's subtitle languages
    private String language_subtitle;
    //genre is a String value that represents an Item's genre
    private String genre;
    //PG_level is a String value that represents an Item's PG rating.
    private String PG_level;
    //ms_hour is a String value that represents how many main story hours are in an Item
    private String ms_hour;
    //ageLimit is a String value that represents the ESRB age recommendation of an Item.
    private String ageLimit;
    //producer is a String value that represents the producer of an Item
    private String producer;
    //publisher is a String value that represents the publisher of an Item.
    private String publisher;
    //price is a String value that represents the price of an Item
    private String price;
    //pages is a String value that represents the number of pages in an Item
    private String pages;

    public Item()
    {
        type = 0;
    }

    /**
     * The setType method sets the type of an Item
     * @param type is an integer representing type
     * @author Caelan Herzberg
     */
    public void setType( int type)
    {
        this.type = type;

    }

    /**
     * The getType method gets an Item's type
     * @return int
     * @author Caelan Herzberg
     */
    public int getType()
    {
        return this.type;

    }

    /**
     * The setCategory method sets the Category of an Item
     * @param category is a String representing an Item's category
     * @author Caelan Herzberg
     */
    public void setCategory( String category)
    {
        this.category = category;

    }

    /**
     * The getCategory method gets an Item's category
     * @return String
     * @author Caelan Herzberg
     */
    public String getCategory()
    {
        return this.category;

    }

    /**
     * The setPages method sets amount of pages in an Item
     * @param pages is a String representing the number of pages in a book
     * @author Caelan Herzberg
     */
    public void setPages( String pages)
    {
        this.pages = pages;

    }

    /**
     * The getPages method gets an Item's page count
     * @return String
     * @author Caelan Herzberg
     */
    public String getPages()
    {
        return this.pages;

    }


    /**
     * The setUrl method sets the URL that leads to an Item's video
     * @param url is a String link to a video
     * @author Caelan Herzberg
     */
    public void setUrl( String url)
    {
        this.url = url;

    }

    /**
     * The getUrl method gets an Item's url
     * @return String
     * @author Caelan Herzberg
     */
    public String getUrl()
    {
        return this.url;

    }


    /**
     * The setID method sets the ID of an Item
     * @param id is a String representing an Item's id
     * @author Caelan Herzberg
     */
    public void setID(String id)
    {
        this.id = id;

    }

    /**
     * The getID method gets an Item's id
     * @return String
     * @author Caelan Herzberg
     */
    public String getID()
    {
        return this.id;

    }

    /**
     * The setPic method sets an Item's link to it's picture
     * @param pic is a String linking to an Item's picture
     * @author Caelan Herzberg
     */
    public void setPic( String pic)
    {
        this.pic = pic;

    }

    /**
     * The getPic method gets an Item's pic link
     * @return String
     * @author Caelan Herzberg
     */
    public String getPic()
    {
        return this.pic;

    }

    /**
     * The setCode is a method that sets an Item's code.
     * @param code is a String representing an Item's code.
     * @author Caelan Herzberg
     */
    public void setCode( String code)
    {
        this.code = code;

    }

    /**
     * The getCode method gets an Item's code
     * @return String
     * @author Caelan Herzberg
     */
    public String getCode()
    {
        return this.code;

    }

    /**
     * The setName is a method that sets an Item's name.
     * @param name is a String that represents an Item's name
     * @author Caelan Herzberg
     */
    public void setName(String name)
    {
        this.name = name;

    }

    /**
     * The getName method gets an Item's name
     * @return String
     * @author Caelan Herzberg
     */
    public String getName()
    {
        return this.name;

    }

    /**
     * The setDescription method sets the description of an Item
     * @param description is a String representing the description of an Item
     * @author Caelan Herzberg
     */
    public void setDescription(String description)
    {
        this.description = description;

    }

    /**
     * The getDescription method gets an Item's description
     * @return String
     * @author Caelan Herzberg
     */
    public String getDescription()
    {
        return this.description;

    }

    /**
     * The setDate method sets an Item's release_date
     * @param date is String representing an Item's release date
     * @author Caelan Herzberg
     */
    public void setDate(String date)
    {
        this.release_date = date;

    }

    /**
     * The getDate method gets an Item's release_date
     * @return String
     * @author Caelan Herzberg
     */
    public String getDate()
    {
        return this.release_date;

    }

    /**
     * The setScore method sets an Item's score
     * @param score is a String representing an Item's score
     * @author Caelan Herzberg
     */
    public void setScore(String score)
    {
        this.score = score;

    }

    /**
     * The getScore method gets an Item's score
     * @return String
     * @author Caelan Herzberg
     */
    public String getScore()
    {
        return this.score;

    }

    /**
     * The setPlatform method sets the platform of an Item
     * @param platform is String representing an Item's platform
     * @author Caelan Herzberg
     */
    public void setPlatform(String platform)
    {
        this.platform = platform;

    }

    /**
     * The getPlatform method gets an Item's platform
     * @return String
     * @author Caelan Herzberg
     */
    public String getPlatform()
    {
        return this.platform;

    }

    /**
     * The setAddress method sets an Item's address
     * @param address is a String representing an Item's address
     * @author Caelan Herzberg
     */
    public void setAddress(String address)
    {
        this.address = address;

    }

    /**
     * The getAddress method gets an Item's address
     * @return String
     * @author Caelan Herzberg
     */
    public String getAddress()
    {
        return this.address;

    }

    /**
     * The setPriceRange method sets an Item's priceRange
     * @param priceRange is a String representing an Item's priceRange
     * @author Caelan Herzberg
     */
    public void setPriceRange(String priceRange)
    {
        this.priceRange = priceRange;

    }

    /**
     * The getPriceRange method gets an Item's priceRange
     * @return String
     * @author Caelan Herzberg
     */
    public String getPriceRange()
    {
        return this.priceRange;

    }

    /**
     * The setPhoneNum method sets an Item's phoneNum
     * @param phoneNum is a String representing an Item's phoneNum
     * @author Caelan Herzberg
     */
    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;

    }

    /**
     * The getPhoneNum method gets an Item's phoneNum
     * @return String
     * @author Caelan Herzberg
     */
    public String getPhoneNum()
    {
        return this.phoneNum;

    }

    /**
     * The setAuthor method sets an Item's author
     * @param author is a String representing an Item's author
     * @author Caelan Herzberg
     */
    public void setAuthor(String author)
    {
        this.author = author;

    }

    /**
     * The getAuthor method gets an Item's author
     * @return String
     * @author Caelan Herzberg
     */
    public String getAuthor()
    {
        return this.author;
    }

    /**
     * The setISBN10 method sets an Item's ISBN_10
     * @param ISBN is a String representing a Item's ISBN_10
     * @author Caelan Herzberg
     */
    public void setISBN10( String ISBN)
    {
        this.ISBN_10 = ISBN;

    }

    /**
     * The getISBN10 method gets an Item's ISBN_10
     * @return String
     * @author Caelan Herzberg
     */
    public String getISBN10()
    {
        return this.ISBN_10;

    }

    /**
     * The setISBN13 method sets an Item's ISBN_13
     * @param ISBN is a String representing an Item's ISBN_13
     * @author Caelan Herzberg
     */
    public void setISBN13( String ISBN)
    {
        this.ISBN_13 = ISBN;

    }

    /**
     * The getISBN13 method gets an Item's ISBN_13
     * @return String
     * @author Caelan Herzberg
     */
    public String getISBN13()
    {
        return this.ISBN_13;

    }

    /**
     * The setStar method sets an Item's star
     * @param star is a String representing an Item's star
     * @author Caelan Herzberg
     */
    public void setStar( String star)
    {
        this.stars = star;

    }

    /**
     * The getStar method gets an Item's stars
     * @return String
     * @author Caelan Herzberg
     */
    public String getStar()
    {
        return this.stars;

    }

    /**
     * The setEpisode method sets an Item's Episode
     * @param episode is a String representing an Item's episode
     * @author Caelan Herzberg
     */
    public void setEpisode( String episode)
    {
        this.episodes = episode;

    }

    /**
     * The getEpisode method gets an Item's episodes
     * @return String
     * @author Caelan Herzberg
     */
    public String getEpisode()
    {
        return this.episodes;

    }

    /**
     * The setMs_hour method sets an Item's ms_hour
     * @param ms_hour is a String representing an Item's ms_hour
     * @author Caelan Herzberg
     */
    public void setMs_hour( String ms_hour)
    {
        this.ms_hour = ms_hour;

    }

    /**
     * The getMs_hour method gets an Item's ms_hour
     * @return String
     * @author Caelan Herzberg
     */
    public String getMs_hour()
    {
        return this.ms_hour;

    }

    /**
     * The setAgeLimit method sets an Item's ageLimit
     * @param ageLimit is a String representing an Item's ageLimit
     * @author Caelan Herzberg
     */
    public void setAgeLimit( String ageLimit)
    {
        this.ageLimit = ageLimit;

    }

    /**
     * The getAgeLimit method gets an Item's ageLimit
     * @return String
     * @author Caelan Herzberg
     */
    public String getAgeLimit()
    {
        return this.ageLimit;

    }

    /**
     * The setTime_length method sets an Item's time_length
     * @param time_length is a String representing an Item's time_length
     * @author Caelan Herzberg
     */
    public void setTime_length( String time_length)
    {
        this.time_length = time_length;

    }

    /**
     * The getTime_length method gets an Item's time_length
     * @return String
     * @author Caelan Herzberg
     */
    public String getTime_length()
    {
        return this.time_length;

    }

    /**
     * The setDirector method sets an Item's director
     * @param director is a String representing an Item's director
     * @author Caelan Herzberg
     */
    public void setDirector( String director)
    {
        this.director = director;

    }

    /**
     * The getDirector method gets an Item's director
     * @return String
     * @author Caelan Herzberg
     */
    public String getDirector()
    {
        return this.director;

    }

    /**
     * The setCountry_of_origin method sets an Item's country_of_origin
     * @param country_of_origin is a String representing an Item's country_of_origin
     * @author Caelan Herzberg
     */
    public void setCountry_of_origin( String country_of_origin)
    {
        this.country_of_origin= country_of_origin;

    }

    /**
     * The getCountry_of_origin method gets an Item's country_of_origin
     * @return String
     * @author Caelan Herzberg
     */
    public String getCountry_of_origin()
    {
        return this.country_of_origin;

    }

    /**
     * The setLanguage method sets an Item's language
     * @param language is a String representing an Item's language
     * @author Caelan Herzberg
     */
    public void setLanguage( String language)
    {
        this.language= language;

    }

    /**
     * The getLanguage method gets an Item's language
     * @return String
     * @author Caelan Herzberg
     */
    public String getLanguage()
    {
        return this.language;

    }

    /**
     * The setPlace method sets an Item's place
     * @param place is a String representing an Item's place
     * @author Caelan Herzberg
     */
    public void setPlace( String place)
    {
        this.place= place;

    }

    /**
     * The getPlace method gets an Item's place
     * @return String
     * @author Caelan Herzberg
     */
    public String getPlace()
    {
        return this.place;

    }

    /**
     * The setLanguage_subtitle method sets an Item's language_subtitle
     * @param language_subtitle is a String representing an Item's language_subtitle
     * @author Caelan Herzberg
     */
    public void setLanguage_subtitle( String language_subtitle)
    {
        this.language_subtitle= language_subtitle;

    }

    /**
     * The getLanguage_subtitle method gets an Item's language_subtitle
     * @return String
     * @author Caelan Herzberg
     */
    public String getLanguage_subtitle()
    {
        return this.language_subtitle;

    }

    /**
     * The setGenre method sets an Item's genre
     * @param genre is a String representing an Item's genre
     * @author Caelan Herzberg
     */
    public void setGenre( String genre)
    {
        this.genre= genre;

    }

    /**
     * The getGenre method gets an Item's genre
     * @return String
     * @author Caelan Herzberg
     */
    public String getGenre()
    {
        return this.genre;

    }

    /**
     * The setPG_level method sets an Item's PG_level
     * @param PG_level is a String representing an Item's PG_level
     * @author Caelan Herzberg
     */
    public void setPG_level( String PG_level)
    {
        this.PG_level = PG_level;

    }

    /**
     * The getPG_level method gets an Item's PG_level
     * @return String
     * @author Caelan Herzberg
     */
    public String getPG_level()
    {
        return this.PG_level;

    }

    /**
     * The setProducer method sets an Item's producer
     * @param producer is a String representing an Item's producer
     * @author Caelan Herzberg
     */
    public void setProducer( String producer)
    {
        this.producer= producer;

    }

    /**
     * The getProducer method gets an Item's producer
     * @return String
     * @author Caelan Herzberg
     */
    public String getProducer()
    {
        return this.producer;

    }

    /**
     * The setPublisher method sets an Item's publisher
     * @param publisher is a String representing an Item's publisher
     * @author Caelan Herzberg
     */
    public void setPublisher( String publisher)
    {
        this.publisher= publisher;

    }

    /**
     * The getPublisher method gets an Item's publisher
     * @return String
     * @author Caelan Herzberg
     */
    public String getPublisher()
    {
        return this.publisher;

    }

    /**
     * The setPrice method sets an Item's price
     * @param price is a String representing an Item's price
     * @author Caelan Herzberg
     */
    public void setPrice( String price)
    {
        this.price= price;

    }

    /**
     * The getPrice method gets an Item's price
     * @return String
     * @author Caelan Herzberg
     */
    public String getPrice()
    {
        return this.price;

    }

}
