package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.Admin;
import demo2BackEnd.categories.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUser(User usr);
}

