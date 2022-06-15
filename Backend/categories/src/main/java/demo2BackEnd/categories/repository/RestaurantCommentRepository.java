package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.RestaurantCategory;
import demo2BackEnd.categories.model.RestaurantComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantCommentRepository extends JpaRepository<RestaurantComment, Long> {
    @Query("SELECT COUNT(rs) FROM RestaurantComment rs WHERE rs.restaurant = :restaurant")
    long countCommentByName(RestaurantCategory restaurant);
}
