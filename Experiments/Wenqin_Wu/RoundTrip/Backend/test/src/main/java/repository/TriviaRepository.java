package repository;

import model.Trivia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TriviaRepository extends JpaRepository<Trivia,Long> {

    List<Trivia> finalAll();
}
