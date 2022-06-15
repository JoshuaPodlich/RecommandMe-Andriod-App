package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.RestaurantCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantCategoryRepository extends JpaRepository<RestaurantCategory, Long> {
    RestaurantCategory findByName(String name);
}
