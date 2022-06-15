package demo2BackEnd.categories.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;

@Entity
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long book_id;

    private String pic;
    @NotBlank
    @Size(min = 1, max = 50)
    private String name;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String author;
    @NotBlank
    @Size(min = 8, max = 10)
    private String release_date;
    @Size(min = 10, max =10)
    private String ISBN_10;
    @Size(min = 13, max = 13)
    private String ISBN_13;
    private String place;
    @NotBlank
    @Size(min = 0, max = 10)
    private long score;
    @Size(min = 2, max = 6)
    private String price;
    private String language;
    private String publisher;
    @NotBlank
    @Size(min = 1, max = 100000)
    private int pages;

    public BookCategory(long book_id, String pic, String name, String description, String author, String release_date, String ISBN_10, String ISBN_13, String place, long score, String price, String language, String publisher, int pages) {
        this.book_id = book_id;
        this.pic = pic;
        this.name = name;
        this.description = description;
        this.author = author;
        this.release_date = release_date;
        this.ISBN_10 = ISBN_10;
        this.ISBN_13 = ISBN_13;
        this.place = place;
        this.score = score;
        this.price = price;
        this.language = language;
        this.publisher = publisher;
        this.pages = pages;
    }

    public BookCategory(){

    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getISBN_10() {
        return ISBN_10;
    }

    public void setISBN_10(String ISBN_10) {
        this.ISBN_10 = ISBN_10;
    }

    public String getISBN_13() {
        return ISBN_13;
    }

    public void setISBN_13(String ISBN_13) {
        this.ISBN_13 = ISBN_13;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
