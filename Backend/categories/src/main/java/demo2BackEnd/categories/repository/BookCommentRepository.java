package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.BookCategory;
import demo2BackEnd.categories.model.BookComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookCommentRepository extends JpaRepository<BookComment, Long> {
    @Query("SELECT COUNT(bc) FROM BookComment bc WHERE bc.book = :book")
    long countCommentByName(BookCategory book);
}
