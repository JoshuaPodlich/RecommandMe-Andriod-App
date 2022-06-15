package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieCategoryRepository extends JpaRepository<MovieCategory, Long> {
    MovieCategory findByName(String name);
}

