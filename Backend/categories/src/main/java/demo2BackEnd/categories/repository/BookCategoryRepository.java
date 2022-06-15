package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
    BookCategory findByName(String name);
}

