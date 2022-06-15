package demo2BackEnd.categories.model;

import demo2BackEnd.categories.model.Admin;
import demo2BackEnd.categories.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class AdminTest {
    private long admin_id;
    private long id;
    private String username;
    private String password;
    private String email;
    private String pic;
    private String gender;
    private UUID userid;
    private boolean banned;
    private boolean isComment;

    public AdminTest(long admin_id, long id, String username, String password, String email, String pic, String gender, boolean banned, boolean isComment) {
        this.admin_id = admin_id;
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
                Object[] d = new Object[9];
                d[0] = 1;
                d[1] = Long.parseLong(dataArray[0]);
                d[2] = dataArray[1];
                d[3] = dataArray[2];
                d[4] = dataArray[3];
                d[5] = dataArray[4];
                d[6] = dataArray[5];
                d[7] = Boolean.parseBoolean(dataArray[6]);
                d[8] = Boolean.parseBoolean(dataArray[7]);

                retList.add(d);

            }
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return retList;
    }

    @Test
    public void admin_test_1() throws Exception{
        User usr = new User("WalkingDeaDJ", "asdbasdba123@", "JS@iastate.edu", null, "male");
        Admin admin = new Admin(1l, usr);
        assertEquals(1l, (long)admin.getAdmin_id());
        assertNotNull(admin.getUser());
    }

    @Test
    public void admin_test_2() throws Exception{
        Admin admin = new Admin();
        assertNull(admin.getUser());
    }

    @Test
    public void admin_test_3() throws Exception{
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
        Admin admin = new Admin();
        admin.setUser(usr);
        admin.setAdmin_id(1l);
        assertEquals(1l, admin.getAdmin_id());
        assertNotNull(admin.getUser());
    }
}
