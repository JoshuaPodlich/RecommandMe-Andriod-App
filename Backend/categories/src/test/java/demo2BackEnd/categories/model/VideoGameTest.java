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
public class VideoGameTest {
    long id;

    private String pic;
    private String name;
    private String description;
    private String release_date;
    private String ms_hour;//main story hours to beat
    private double score;
    private String platform;
    private String ageLimit;
    private String type;
    private int price;
    private String publisher;
    private String producer;
    private String url;

    public VideoGameTest(long id, String pic, String name, String description, String release_date, String ms_hour, double score,
                         String platform, String ageLimit, String type, int price, String publisher, String producer,String url) {
        this.id = id;
        this.pic = pic;
        this.name = name;
        this.description = description;
        this.release_date = release_date;
        this.ms_hour = ms_hour;
        this.score = score;
        this.platform = platform;
        this.ageLimit = ageLimit;
        this.type = type;
        this.price = price;
        this.publisher = publisher;
        this.producer = producer;
        this.url= url;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Collection<Object[]> retList = new ArrayList<Object[]>();
        try {
            Scanner in = new Scanner(new File("VGFile.txt"));
            while (in.hasNextLine()) {
                String l = in.nextLine();
                String dataArray[] = l.split(",");
                Object[] d = new Object[14];
                d[0] = Long.parseLong(dataArray[0]);
                d[1] = dataArray[1];
                d[2] = dataArray[2];
                d[3] = dataArray[3];
                d[4] = dataArray[4];
                d[5] = dataArray[5];
                d[6] = Double.parseDouble(dataArray[6]);
                d[7] = dataArray[7];
                d[8] = dataArray[8];
                d[9] = dataArray[9];
                d[10] = Integer.parseInt(dataArray[10]);
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
    public void Restaurant_test_1(){
        VideoGameCategory vg = new VideoGameCategory(id,pic,name, description, release_date, ms_hour, score,platform,ageLimit,type,price,publisher,producer,url);
        assertEquals(1l, vg.getId());
        assertEquals("type",vg.getType());
        assertEquals("null", vg.getPic());
        assertEquals("name", vg.getName());
        assertEquals(1.1, vg.getScore());
        assertEquals(60,vg.getPrice());
        assertEquals("age", vg.getAgeLimit());
        assertNotNull(vg.getPic());
        assertEquals("url",vg.getUrl());
        assertEquals("producer",vg.getProducer());
        assertEquals("pulbisher",vg.getPublisher());
        assertEquals("ms",vg.getMs_hour());
        assertEquals("des",vg.getDescription());
        assertEquals("plat",vg.getPlatform());
        vg.setScore(1l);
        vg.setType("type");
        vg.setPrice(123);
        vg.setPublisher("123");
        vg.setProducer("123");
        vg.setUrl("123");
        vg.setId(1l);
        vg.setMs_hour("123");
        vg.setPic("null");
        vg.setRelease_date("123");
    }
}
