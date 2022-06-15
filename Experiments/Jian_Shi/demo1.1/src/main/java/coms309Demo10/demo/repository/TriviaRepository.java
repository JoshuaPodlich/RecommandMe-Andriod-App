package coms309Demo10.demo.repository;

import coms309Demo10.demo.model.Trivia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriviaRepository extends JpaRepository<Trivia, Long> {
}
