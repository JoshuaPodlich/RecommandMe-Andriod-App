package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.BookCategory;
import demo2BackEnd.categories.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}

