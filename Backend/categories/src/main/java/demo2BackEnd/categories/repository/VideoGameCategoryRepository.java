package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.VideoGameCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoGameCategoryRepository extends JpaRepository<VideoGameCategory, Long> {
    VideoGameCategory findByName(String name);
}
