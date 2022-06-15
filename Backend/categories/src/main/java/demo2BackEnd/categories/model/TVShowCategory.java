package demo2BackEnd.categories.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;

@Entity
public class TVShowCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    long id;

    private String pic;
    @NotBlank
    @Size(min = 0, max = 10)
    private String name;
    @NotBlank
    @Size(min = 1, max = 5)
    private String stars;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private int episodes;
    @NotBlank
    @Size(min = 1, max = 20)
    private String platform;
    @NotBlank
    @Size(min = 0, max = 10)
    private double score;
    private String language_Subtitle;
    private String type;
    private String PG_level;
    @Column(name = "url", columnDefinition = "LONGTEXT")
    private String url;

    public TVShowCategory(long id, String pic, String name, String stars, String description, int episodes, String platform, double score, String language_Subtitle, String type, String PG_level, String url) {
        this.id = id;
        this.pic = pic;
        this.name = name;
        this.stars = stars;
        this.description = description;
        this.episodes = episodes;
        this.platform = platform;
        this.score = score;
        this.language_Subtitle = language_Subtitle;
        this.type = type;
        this.PG_level = PG_level;
        this.url = url;
    }

    public TVShowCategory() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage_Subtitle() {
        return language_Subtitle;
    }

    public void setLanguage_Subtitle(String language_Subtitle) {
        this.language_Subtitle = language_Subtitle;
    }

    public String getPG_level() {
        return PG_level;
    }

    public void setPG_level(String PG_level) {
        this.PG_level = PG_level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
