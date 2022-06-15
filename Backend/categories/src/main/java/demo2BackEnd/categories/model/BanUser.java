package demo2BackEnd.categories.model;

import javax.persistence.*;
import java.io.File;
import java.util.UUID;

@Entity
public class BanUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;
    @Column(name = "userid", columnDefinition = "BINARY(36)")
    private UUID userid;
    private String reasons;

    public BanUser(Long id, User user, String reasons) {
        this.id = id;
        this.user = user;
        this.reasons = reasons;
    }

    public BanUser(String reasons) {
        this.reasons = reasons;
    }

    public BanUser() {

    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }
}
