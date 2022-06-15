package demo2BackEnd.categories.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.Serializable;


@Entity
public class VideoGameCategory implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String pic;
    @NotBlank
    @Size(min = 0, max = 50)
    private String name;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    @NotBlank
    @Size(min = 1, max = 20)
    private String release_date;
    @NotBlank
    @Size(min = 1, max = 3)
    private String ms_hour;//main story hours to beat
    @NotBlank
    @Size(min = 0, max = 10)
    private double score;
    private String platform;
    @NotBlank
    @Size(min = 1, max = 3)
    private String ageLimit;
    private String type;
    @NotBlank
    @Size(min = 1, max = 3)
    private int price;
    private String publisher;
    private String producer;

    public VideoGameCategory(long id, String pic, String name, String description, String release_date, String ms_hour, double score, String platform, String ageLimit, String type, int price, String publisher, String producer, String url) {
        this.id = id;
        this.pic = pic;
        this.name = name;
        this.description = description;
        this.release_date = release_date;
        this.ms_hour = ms_hour;
        this.score = score;
        this.platform = platform;
        this.ageLimit = ageLimit;
        this.type = type;
        this.price = price;
        this.publisher = publisher;
        this.producer = producer;
        this.url = url;
    }

    public VideoGameCategory(){

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Column(name = "url", columnDefinition = "LONGTEXT")
    private String url;

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

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getMs_hour() {
        return ms_hour;
    }

    public void setMs_hour(String ms_hour) {
        this.ms_hour = ms_hour;
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
