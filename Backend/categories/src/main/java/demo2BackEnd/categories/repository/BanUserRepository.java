package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.BanUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BanUserRepository extends JpaRepository<BanUser, Long> {
    BanUser findByUserId(UUID userid);
}

