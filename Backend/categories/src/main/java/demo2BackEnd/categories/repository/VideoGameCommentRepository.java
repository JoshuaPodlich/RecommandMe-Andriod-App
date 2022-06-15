package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.RestaurantCategory;
import demo2BackEnd.categories.model.VideoGameCategory;
import demo2BackEnd.categories.model.VideoGameComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VideoGameCommentRepository extends JpaRepository<VideoGameComment, Long> {
    @Query("SELECT COUNT(vg) FROM VideoGameComment vg WHERE vg.videoGameCategory = :videoGame")
    long countCommentByName(VideoGameCategory videoGame);
}
