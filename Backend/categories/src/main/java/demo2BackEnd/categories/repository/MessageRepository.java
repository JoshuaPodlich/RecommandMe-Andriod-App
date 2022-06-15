package demo2BackEnd.categories.repository;

import demo2BackEnd.categories.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
