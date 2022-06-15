package demo2BackEnd.categories.model;

import javax.persistence.*;
import java.io.File;
import java.util.UUID;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long admin_id;
    @Column(name = "userid", columnDefinition = "BINARY(36)")
    private UUID userid;

    @OneToOne
    private User user;

    public Admin(long admin_id, User user) {
        this.admin_id = admin_id;
        this.user = user;
    }

    public Admin(){

    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }
}
