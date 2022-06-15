package backend.categories.repository;

import backend.categories.model.TVShowCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TVShowCategoryRepository extends JpaRepository<TVShowCategory, Long> {
}
