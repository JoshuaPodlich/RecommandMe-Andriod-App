package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.comment_id = :id")
    Comment findByComment_id(long id);
}
