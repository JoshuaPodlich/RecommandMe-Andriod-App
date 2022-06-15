package demo2BackEnd.categories.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class TVShowComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @ManyToOne
    @JoinColumn(name = "user")
    User user;

    @ManyToOne
    @JoinColumn(name = "TVShow")
    TVShowCategory tvShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TVShowCategory getTvShow() {
        return tvShow;
    }

    public void setTvShow(TVShowCategory tvShow) {
        this.tvShow = tvShow;
    }
}


