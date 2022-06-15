package demo2BackEnd.categories.model;

import demo2BackEnd.categories.model.MovieCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class MovieTest {
    private long movie_id;
    private String name;
    private String description;
    private long score;
    private String platform;
    private String pic;
    private int time_length;
    private String director;
    private String release_date;
    private String country_of_origin;
    private String language;
    private String types;
    private String url;
    private String PG_level;

    public MovieTest(long movie_id, String name, String description, long score, String platform, String pic, int time_length, String director, String release_date, String country_of_origin, String language, String types, String url, String PG_level) {
        this.movie_id = movie_id;
        this.name = name;
        this.description = description;
        this.score = score;
        this.platform = platform;
        this.pic = pic;
        this.time_length = time_length;
        this.director = director;
        this.release_date = release_date;
        this.country_of_origin = country_of_origin;
        this.language = language;
        this.types = types;
        this.url = url;
        this.PG_level = PG_level;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Collection<Object[]> retList = new ArrayList<Object[]>();
        try {
            Scanner in = new Scanner(new File("movieFile.txt"));
            while (in.hasNextLine()) {
                String l = in.nextLine();
                String dataArray[] = l.split(",");
                Object[] d = new Object[14];
                d[0] = Long.parseLong(dataArray[0]);
                d[1] = dataArray[1];
                d[2] = dataArray[2];
                d[3] = Long.parseLong(dataArray[3]);
                d[4] = dataArray[4];
                d[5] = dataArray[5];
                d[6] = Integer.parseInt(dataArray[6]);
                d[7] = dataArray[7];
                d[8] = dataArray[8];
                d[9] = dataArray[9];
                d[10] = dataArray[10];
                d[11] = dataArray[11];
                d[12] = dataArray[12];
                d[13] = dataArray[13];
                retList.add(d);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return retList;
    }

    @Test
    public void movie_test_1(){
        MovieCategory movie = new MovieCategory(movie_id, name, description, score, platform, pic, time_length, director, release_date, country_of_origin, language, types, PG_level, url);
        assertEquals("The Batman", movie.getName());
        assertEquals("PG-13", movie.getPGlevel());
        assertEquals(1, movie.getMovie_id());
        assertNotNull(movie.getName());
        assertEquals(8, movie.getScore());
        assertNotNull(movie.getPic());
        assertNotNull(movie.getUrl());
        assertEquals("Matt Reeves", movie.getDirector());
        assertEquals("March 18 2022", movie.getRelease_date());
        assertEquals("English", movie.getLanguage());
        assertEquals("Action Drama Crime", movie.getTypes());
        assertEquals(178, movie.getTime_length());
    }

    @Test
    public void movie_test_2(){
        MovieCategory mv = new MovieCategory();
        mv.setScore(8);
        mv.setMovie_id(1l);
        mv.setCountry_of_origin("US");
        mv.setDescription("Test only words");
        mv.setDirector("Jason.S");
        mv.setLanguage("EN");
        mv.setName("TEST");
        mv.setCountry_of_origin("CN");
        mv.setPGlevel(null);
        mv.setPic(null);
        mv.setPlatform("Home");
        mv.setRelease_date("Unknown");
        mv.setTime_length(120);
        mv.setTypes("horrible");
        mv.setUrl(null);
        assertNull(mv.getUrl());
        assertNull(mv.getPic());
        assertNull(mv.getPGlevel());
        assertNotNull(mv);
        assertEquals("Test only words", mv.getDescription());
        assertEquals("Home", mv.getPlatform());
        assertEquals("CN", mv.getCountry_of_origin());
    }
}
