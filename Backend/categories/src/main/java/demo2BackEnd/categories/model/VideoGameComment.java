package demo2BackEnd.categories.model;

import javax.persistence.*;
import java.io.File;

@Entity
public class VideoGameComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne
    @JoinColumn(name = "user")
    User user;

    @ManyToOne
    @JoinColumn(name = "VideoGame")
    VideoGameCategory videoGameCategory;

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

    public VideoGameCategory getVideoGameCategory() {
        return videoGameCategory;
    }

    public void setVideoGameCategory(VideoGameCategory videoGameCategory) {
        this.videoGameCategory = videoGameCategory;
    }
}
