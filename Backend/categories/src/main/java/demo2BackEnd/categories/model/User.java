package demo2BackEnd.categories.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    @Size(min = 1, max = 50)
    private String username;

    @Column(name = "password", columnDefinition = "LONGTEXT")
    @NotBlank
    @Size(min = 1, max = 1000)
    private String password;


    @Size(min = 11, max = 100)
    private String email;
    @Column(name = "pic", columnDefinition = "TEXT")
    private String pic;

    @Size(min = 4, max = 6)
    private String gender;

    @Column(name = "userid", columnDefinition = "BINARY(16)")
    private UUID userID= UUID.randomUUID();

    private boolean banned;

    private boolean isComment;

    private boolean isAdmin;

    public User(Long id, String username, String password, String email, String pic, String gender, boolean banned, boolean isComment) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.pic = pic;
        this.gender = gender;
        this.userID = userID;
        this.banned = banned;
        this.isComment = isComment;
    }

    public User(String username, String password, String email, String pic, String gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.pic = pic;
        this.gender = gender;
    }


    public User(String username, String password, String email, String gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        userID = userID;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public boolean isComment() {
        return isComment;
    }

    public void setComment(boolean comment) {
        isComment = comment;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
