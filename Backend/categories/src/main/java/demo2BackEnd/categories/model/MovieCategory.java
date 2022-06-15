package demo2BackEnd.categories.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class MovieCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long movie_id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String name;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    @NotBlank
    @Size(min = 0, max = 10)
    private long score = 0;

    private String platform;
    private String pic;

    @NotBlank
    @Size(min = 1, max = 190)
    private int time_length;
    private String director;
    @NotBlank
    @Size(min = 8, max = 10)
    private String release_date;
    @Size(min = 1, max = 190)
    private String country_of_origin;
    private String language;
    private String types;
    private String PGlevel;

    @Column(name = "url", columnDefinition = "LONGTEXT")
    private String url;

    public MovieCategory(long id, String name, String description, long score, String platform, String pic, int time_length, String director, String release_date, String country_of_origin, String language, String types, String PGlevel, String url) {
        this.movie_id = id;
        this.name = name;
        this.description = description;
        this.score = score;
        this.platform = platform;
        this.pic = pic;
        this.time_length = time_length;
        this.director = director;
        this.release_date = release_date;
        this.country_of_origin = country_of_origin;
        this.language = language;
        this.types = types;
        this.PGlevel = PGlevel;
        this.url = url;
    }

    public MovieCategory(){

    }

    public String getPGlevel() {
        return PGlevel;
    }

    public void setPGlevel(String PGlevel) {
        this.PGlevel = PGlevel;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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

    public int getTime_length() {
        return time_length;
    }

    public void setTime_length(int time_length) {
        this.time_length = time_length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getCountry_of_origin() {
        return country_of_origin;
    }

    public void setCountry_of_origin(String country_of_origin) {
        this.country_of_origin = country_of_origin;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
