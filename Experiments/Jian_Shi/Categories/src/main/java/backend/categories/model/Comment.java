package backend.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String code;
    private String ReviewText;
    private File pic;
    private Boolean isUpVotes= false;
    private int userID;
    private int guestID;

    public String getCode() {
        return code;
    }

    public void getCode(String code) {
        code = code;
    }

    public String getReviewText() {
        return ReviewText;
    }

    public void setReviewText(String reviewText) {
        ReviewText = reviewText;
    }

    public boolean getUpVotes() {
        return isUpVotes;
    }

    public void setUpVotes(boolean isUpVotes) {
        this.isUpVotes = isUpVotes;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }
}
