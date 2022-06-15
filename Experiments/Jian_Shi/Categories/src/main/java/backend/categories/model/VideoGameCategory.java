package backend.categories.model;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;


@Entity
public class VideoGameCategory implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private File pic;
    private String code = "VG";//Video Game Category code (a referrence for comment table)
    private String name;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String date;
    private String ms_hour;//main story hours to beat
    private double score;
    private String platform;
    private String ageLimit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMs_hour() {
        return ms_hour;
    }

    public void setMs_hour(String ms_hour) {
        this.ms_hour = ms_hour;
    }

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }
}
