package demo2BackEnd.categories.model;

import demo2BackEnd.categories.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class TVShowTest {
    long id;

    private String pic;
    private String name;
    private String stars;
    private String description;
    private int episodes;
    private String platform;
    private double score;
    private String language_Subtitle;
    private String type;
    private String PG_level;
    private String url;

    // 11 total
    public TVShowTest(long id, String pic, String name, String stars, String description, int episodes, String platform,
                      double score, String language_Subtitle, String type, String PG_level, String url) {
        this.id = id;
        this.pic = pic;
        this.name = name;
        this.stars = stars;
        this.description = description;
        this.episodes = episodes;
        this.platform = platform;
        this.score = score;
        this.language_Subtitle = language_Subtitle;
        this.type = type;
        this.PG_level = PG_level;
        this.url = url;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Collection<Object[]> retList = new ArrayList<Object[]>();
        try {
            Scanner in = new Scanner(new File("tvFile.txt"));

            while (in.hasNextLine()) {
                String l = in.nextLine();

                String dataArray[] = l.split(",");
                Object[] d = new Object[12];
                d[0] = Long.parseLong(dataArray[0]);
                d[1] = dataArray[1];
                d[2] = dataArray[2];
                d[3] = dataArray[3];
                d[4] = dataArray[4];
                d[5] = Integer.parseInt(dataArray[5]);
                d[6] = dataArray[6];
                d[7] = Double.parseDouble(dataArray[7]);
                d[8] = dataArray[8];
                d[9] = dataArray[9];
                d[10] = dataArray[10];
                d[11] = dataArray[11];
                retList.add(d);
            }
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return retList;
    }

    @Test
    public void TVShowTest1() throws Exception{
        TVShowCategory tv = new TVShowCategory(id,pic,name,stars,description,episodes,platform,score,language_Subtitle,type,PG_level,url);

        assertEquals(1l,tv.getId());
        assertEquals("name",tv.getName());
        assertEquals("stars",tv.getStars());
        assertEquals("url",tv.getUrl());
        assertEquals("null",tv.getPic());
        assertEquals(1.1,tv.getScore());
        assertEquals(1,tv.getEpisodes());
        assertEquals("descritpion",tv.getDescription());
        assertEquals("PG_level",tv.getPG_level());
        assertEquals("platform",tv.getPlatform());
        assertEquals("language_Subtitle",tv.getLanguage_Subtitle());

        tv.setId(1l);
        tv.setName("name");
        tv.setStars("3");
        tv.setUrl("url");
        tv.setPic("null");
        tv.setScore(2);
        tv.setEpisodes(1);
        tv.setDescription("des");
        tv.setPG_level("pg_level");
        tv.setPlatform("plat");
        tv.setLanguage_Subtitle("langugae");
    }
}
