package demo2BackEnd.categories.model;

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
public class tvCommentTest {
    private long id;
    private User usr;
    private MovieCategory mv;

    private long userid;
    private String username;
    private String password;
    private String email;
    private String pic;
    private String gender;
    private boolean banned;
    private boolean isComment;

    public tvCommentTest(long id, String username, String password, String email, String pic, String gender, boolean banned, boolean isComment) {
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
            Scanner in = new Scanner(new File("userFile.txt"));

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
                d[6] = Boolean.parseBoolean(dataArray[6]);
                d[7] = Boolean.parseBoolean(dataArray[7]);

                retList.add(d);

            }
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return retList;
    }

    @Test
    public void mv_comment_test1() throws Exception{
        User usr = new User();
        TVShowCategory mv = new TVShowCategory();
        TVShowComment mvc = new TVShowComment();
        mvc.setUser(usr);
        mvc.setTvShow(mv);
        mvc.setId(1l);
        assertEquals(1l, (long)mvc.getId());
        assertNotNull(mvc.getUser());
        assertNotNull(mvc.getTvShow());
    }
}

