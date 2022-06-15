package controller;

import model.Trivia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.TriviaRepository;

import java.util.List;

@RestController
public class TriviaController {
    @Autowired
    TriviaRepository triviaRepository;

    @GetMapping("trivia/all")
    List<Trivia> GetAllTrivia(){
        return triviaRepository.finalAll();
    }

    @PostMapping("triva/post/{q}/{a}")
    Trivia PostTriviaByPath(@PathVariable String q, @PathVariable String a){
        Trivia newTrivia = new Trivia();
        newTrivia.setQuestion(q);
        newTrivia.setAnswers(q);
        triviaRepository.save(newTrivia);
        return newTrivia;
    }

    @PostMapping("triva/post")
    Trivia PostTriviaByPath(@RequestBody Trivia newTrivia){
        triviaRepository.save(newTrivia);
        return newTrivia;
    }
}
