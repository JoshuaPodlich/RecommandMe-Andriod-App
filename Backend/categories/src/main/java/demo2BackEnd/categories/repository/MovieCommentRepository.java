package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.MovieCategory;
import demo2BackEnd.categories.model.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieCommentRepository extends JpaRepository<MovieComment, Long> {
    @Query("SELECT COUNT(mc) FROM MovieComment mc WHERE mc.movie = :movie")
    long countCommentByName(MovieCategory movie);

}
