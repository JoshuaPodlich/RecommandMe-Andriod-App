package demo2BackEnd.categories.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long comment_id;
    private String ReviewText;
    private boolean isUpVotes= false;
    @NotBlank
    @Size(min = 0, max = 10)
    private long rating;

    @ManyToOne
    private User user;

    @ManyToOne
    private MovieCategory mvCategory;
    @ManyToOne
    private BookCategory bkCategory;
    @ManyToOne
    private RestaurantCategory rsCategory;
    @ManyToOne
    private TVShowCategory tvShowCategory;
    @ManyToOne
    private VideoGameCategory videoGameCategory;

    public Comment(long id, String reviewText, boolean isUpVotes, long rating, User user) {
        this.comment_id = id;
        this.ReviewText = reviewText;
        this.isUpVotes = isUpVotes;
        this.rating = rating;
        this.user = user;
    }

    public Comment(String reviewText, boolean isUpVotes, long rating){
        this.ReviewText = reviewText;
        this.isUpVotes = isUpVotes;
        this.rating = rating;
    }

    public Comment() {

    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public String getReviewText() {
        return ReviewText;
    }

    public void setReviewText(String reviewText) {
        ReviewText = reviewText;
    }

    public boolean getUpVotes() {
        return isUpVotes;
    }

    public void setUpVotes(boolean upVotes) {
        isUpVotes = upVotes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public MovieCategory getMvCategory() {
        return mvCategory;
    }

    public void setMvCategory(MovieCategory mvCategory) {
        this.mvCategory = mvCategory;
    }

    public BookCategory getBkCategory() {
        return bkCategory;
    }

    public void setBkCategory(BookCategory bkCategory) {
        this.bkCategory = bkCategory;
    }

    public RestaurantCategory getRsCategory() {
        return rsCategory;
    }

    public void setRsCategory(RestaurantCategory rsCategory) {
        this.rsCategory = rsCategory;
    }
    public TVShowCategory getTvShowCategory() {
        return tvShowCategory;
    }

    public VideoGameCategory getVideoGameCategory() {
        return videoGameCategory;
    }

    public void setVideoGameCategory(VideoGameCategory videoGameCategory) {
        this.videoGameCategory = videoGameCategory;
    }

    public void setTvShowCategory(TVShowCategory tvShowCategory) {
        this.tvShowCategory = tvShowCategory;
    }
}
