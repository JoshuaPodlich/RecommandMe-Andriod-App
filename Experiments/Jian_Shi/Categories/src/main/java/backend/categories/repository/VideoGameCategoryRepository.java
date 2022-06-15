package backend.categories.repository;

import backend.categories.model.VideoGameCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoGameCategoryRepository extends JpaRepository<VideoGameCategory, Long> {
}
