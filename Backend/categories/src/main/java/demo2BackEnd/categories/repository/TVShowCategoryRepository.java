package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.RestaurantCategory;
import demo2BackEnd.categories.model.TVShowCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TVShowCategoryRepository extends JpaRepository<TVShowCategory, Long> {
    TVShowCategory findByName(String name);
}
