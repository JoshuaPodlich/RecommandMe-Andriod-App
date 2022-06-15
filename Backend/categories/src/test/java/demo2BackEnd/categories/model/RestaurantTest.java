package demo2BackEnd.categories.model;

import demo2BackEnd.categories.model.MovieCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class RestaurantTest {
    long restaurant_id;
    private String pic;
    private String name;
    private String description;
    private String address;
    private String priceRange;
    private String phoneNum;
    private long score;


    public RestaurantTest(long restaurant_id, String pic, String name, String description, String address, String priceRange, String phoneNum, long score) {
        this.restaurant_id = restaurant_id;
        this.pic = pic;
        this.name = name;
        this.description = description;
        this.address = address;
        this.priceRange = priceRange;
        this.phoneNum = phoneNum;
        this.score = score;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Collection<Object[]> retList = new ArrayList<Object[]>();
        try {
            Scanner in = new Scanner(new File("rsFile.txt"));
            while (in.hasNextLine()) {
                String l = in.nextLine();
                String dataArray[] = l.split(",");
                Object[] d = new Object[8];
                d[0] = Long.parseLong(dataArray[0]);
                d[1] = dataArray[1];
                d[2] = dataArray[2];
                d[3] = dataArray[3];
                d[4] = dataArray[4];
                d[5] = dataArray[5];
                d[6] = dataArray[6];
                d[7] = Long.parseLong(dataArray[7]);
                retList.add(d);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return retList;
    }

    @Test
    public void Restaurant_test_1(){
        RestaurantCategory rs = new RestaurantCategory(restaurant_id,pic, name, description, address, priceRange, phoneNum, score);
        assertEquals(1l, rs.getId());
        assertEquals("null", rs.getPic());
        assertEquals("name", rs.getName());
        assertNotNull(rs.getName());
        assertEquals(8, rs.getScore());
        assertNotNull(rs.getPic());
        assertEquals("address", rs.getAddress());
        assertNotNull(rs.getAddress());
        assertEquals("phoneNum", rs.getPhoneNum());
        assertNotNull(rs.getPhoneNum());
        rs.setScore(5l);
        assertNotNull(rs.getId());
        rs.setAddress("address");
        rs.setDescription("description");
        rs.setId(1l);
        rs.setPhoneNum("123");
        rs.setPic("null");
        rs.setPriceRange("$$");
        rs.setScore(4l);
    }

//    @Test
//    public void movie_test_2(){
//        MovieCategory mv = new MovieCategory();
//        mv.setScore(8);
//        mv.setMovie_id(1l);
//        mv.setCountry_of_origin("US");
//        mv.setDescription("Test only words");
//        mv.setDirector("Jason.S");
//        mv.setLanguage("EN");
//        mv.setName("TEST");
//        mv.setCountry_of_origin("CN");
//        mv.setPGlevel(null);
//        mv.setPic(null);
//        mv.setPlatform("Home");
//        mv.setRelease_date("Unknown");
//        mv.setTime_length(120);
//        mv.setTypes("horrible");
//        mv.setUrl(null);
//        assertNull(mv.getUrl());
//        assertNull(mv.getPic());
//        assertNull(mv.getPGlevel());
//        assertNotNull(mv);
//        assertEquals("Test only words", mv.getDescription());
//        assertEquals("Home", mv.getPlatform());
//        assertEquals("CN", mv.getCountry_of_origin());
//    }
}
