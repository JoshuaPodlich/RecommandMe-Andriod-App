package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.BookCategory;
import demo2BackEnd.categories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByBannedTrue();
    User findByUserID(UUID userid);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

}

