package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.TVShowCategory;
import demo2BackEnd.categories.model.TVShowComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TVShowCommentRepository extends JpaRepository<TVShowComment, Long> {
    @Query("SELECT COUNT(tv) FROM TVShowComment tv WHERE tv.tvShow = :tvshow")
    long countCommentByName(TVShowCategory tvshow);
}
