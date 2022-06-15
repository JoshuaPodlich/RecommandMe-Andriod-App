package demo2BackEnd.categories.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import demo2BackEnd.categories.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UserTest {
    private long id;
    private String username;
    private String password;
    private String email;
    private String pic;
    private String gender;
    private UUID userid;
    private boolean banned;
    private boolean isComment;

    public UserTest(long id, String username, String password, String email, String pic, String gender, boolean banned, boolean isComment) {
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
    public void user_test_1() throws Exception{
        User usr = new User(id, username, password, email, pic, gender, banned, isComment);
        assertEquals(false, usr.isBanned());
        assertEquals(true, usr.isComment());
        assertEquals("WalkingDeaDJ", usr.getUsername());
        assertEquals("asdbasdba123@", usr.getPassword());
        assertEquals("JS@iastate.edu", usr.getEmail());
        assertEquals("null", usr.getPic());
        assertEquals("male",usr.getGender());
    }

    @Test
    public void user_test_2() throws Exception{
        User usr = new User("WalkingDeaDJ", "asdbasdba123@", "JS@iastate.edu", null, "male");
        assertEquals("WalkingDeaDJ", usr.getUsername());
        assertEquals("asdbasdba123@", usr.getPassword());
        assertEquals("JS@iastate.edu", usr.getEmail());
        assertEquals(null, usr.getPic());
        assertEquals("male",usr.getGender());
    }

    @Test
    public void user_test_3() throws Exception{
        User usr = new User("WalkingDeaDJ", "asdbasdba123@", "JS@iastate.edu", "male");
        assertEquals("WalkingDeaDJ", usr.getUsername());
        assertEquals("asdbasdba123@", usr.getPassword());
        assertEquals("JS@iastate.edu", usr.getEmail());
        assertEquals("male",usr.getGender());
    }

    @Test
    public void user_test_4() throws Exception{
        User usr = new User();
        assertNull(usr.getUsername());
    }

    @Test
    public void user_test_5() throws Exception{
        User usr = new User();
        usr.setBanned(false);
        usr.setComment(false);
        usr.setUsername("WalkingDeaDJ");
        usr.setGender("male");
        usr.setPassword("asdbasdba123@");
        usr.setEmail("JS@iastate.edu");
        usr.setPic(null);
        usr.setId(1l);
        usr.setUserID(UUID.randomUUID());
        assertNotNull(usr);
        assertEquals(false, usr.isBanned());
        assertEquals(false, usr.isComment());
        assertEquals("WalkingDeaDJ", usr.getUsername());
        assertEquals("asdbasdba123@", usr.getPassword());
        assertEquals("JS@iastate.edu", usr.getEmail());
        assertEquals(null, usr.getPic());
        assertEquals("male",usr.getGender());
        assertEquals(usr.getUserID(), usr.getUserID());
        assertEquals(1l, (long)usr.getId());
    }

}
