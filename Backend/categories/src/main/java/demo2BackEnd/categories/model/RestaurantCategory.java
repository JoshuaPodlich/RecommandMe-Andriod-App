package demo2BackEnd.categories.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;

@Entity
public class RestaurantCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    long restaurant_id;

    private String pic;

    @NotBlank
    @Size(min = 1, max = 50)
    private String name;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String address;
    @NotBlank
    @Size(min = 1, max = 5)
    private String priceRange;
    @NotBlank
    @Size(min = 12, max = 12)
    private String phoneNum;
    @NotBlank
    @Size(min = 0, max = 10)
    private long score;

    public RestaurantCategory(long restaurant_id, String pic, String name, String description, String address, String priceRange, String phoneNum, long score) {
        this.restaurant_id = restaurant_id;
        this.pic = pic;
        this.name = name;
        this.description = description;
        this.address = address;
        this.priceRange = priceRange;
        this.phoneNum = phoneNum;
        this.score = score;
    }

    public RestaurantCategory() {

    }

    public long getId() {
        return restaurant_id;
    }

    public void setId(long restaurant_id) {
        this.restaurant_id = restaurant_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
