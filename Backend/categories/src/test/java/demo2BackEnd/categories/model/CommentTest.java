package demo2BackEnd.categories.model;

import demo2BackEnd.categories.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class CommentTest {
    private long comment_id;
    private String reviewText;
    private boolean isUpVotes;
    private long rating;

    private long id;
    private String username;
    private String password;
    private String email;
    private String pic;
    private String gender;
    private boolean banned;
    private boolean isComment;

    private User user;
    private MovieCategory mvCategory;
    private BookCategory bkCategory;
    private RestaurantCategory rsCategory;
    private TVShowCategory tvShowCategory;
    private VideoGameCategory videoGameCategory;

    public CommentTest(long comment_id, String reviewText, boolean isUpVotes, long rating, long id, String username, String password, String email, String pic, String gender, boolean banned, boolean isComment) {
        this.comment_id = comment_id;
        this.reviewText = reviewText;
        this.isUpVotes = isUpVotes;
        this.rating = rating;
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.pic = pic;
        this.gender = gender;
        this.banned = banned;
        this.isComment = isComment;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Collection<Object[]> retList = new ArrayList<Object[]>();
        try {
            Scanner in = new Scanner(new File("commentFile.txt"));

            while (in.hasNextLine()) {
                String l = in.nextLine();

                String dataArray[] = l.split(",");
                Object[] d = new Object[12];
                d[0] = Long.parseLong(dataArray[0]);
                d[1] = dataArray[1];
                d[2] = Boolean.parseBoolean(dataArray[2]);
                d[3] = Long.parseLong(dataArray[3]);
                d[4] = Long.parseLong(dataArray[4]);
                d[5] = dataArray[5];
                d[6] = dataArray[6];
                d[7] = dataArray[7];
                d[8] = dataArray[8];
                d[9] = dataArray[9];
                d[10] = Boolean.parseBoolean(dataArray[10]);
                d[11] = Boolean.parseBoolean(dataArray[11]);
                retList.add(d);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return retList;
    }

    @Test
    public void comment_test_1() throws Exception{
        User usr = new User("WalkingDeaDJ", "asdbasdba123@", "JS@iastate.edu", null, "male");
        Comment cm = new Comment(comment_id, reviewText, isUpVotes, rating, usr);
        assertEquals(1, cm.getComment_id());
        assertEquals("good", cm.getReviewText());
        assertNotNull(cm.getUpVotes());
        assertEquals(8, cm.getRating());
        assertNotNull(cm.getUser());
    }

    @Test
    public void comment_test_2() throws Exception{
        Comment cm = new Comment();
        User usr = new User("WalkingDeaDJ", "asdbasdba123@", "JS@iastate.edu", null, "male");
        cm.setComment_id(1l);
        cm.setReviewText("great");
        cm.setUpVotes(false);
        cm.setRating(7);
        cm.setUser(usr);
        assertNotNull(cm);
        assertNotNull(cm.getUser());
    }

    @Test
    public void comment_test_3() throws Exception{
        Comment cm = new Comment();
        MovieCategory mv = new MovieCategory(1l, "movie", "blablabla", 7, "home", null, 100, null, null, null, null, null, null, null);
        cm.setMvCategory(mv);
        assertNotNull(cm.getMvCategory());
        BookCategory bk = new BookCategory();
        cm.setBkCategory(bk);
        assertNotNull(cm.getBkCategory());
        TVShowCategory tv = new TVShowCategory();
        cm.setTvShowCategory(tv);
        assertNotNull(cm.getTvShowCategory());
        RestaurantCategory rs = new RestaurantCategory();
        cm.setRsCategory(rs);
        assertNotNull(cm.getRsCategory());
        VideoGameCategory vg = new VideoGameCategory();
        cm.setVideoGameCategory(vg);
        assertNotNull(cm.getVideoGameCategory());
    }
}
