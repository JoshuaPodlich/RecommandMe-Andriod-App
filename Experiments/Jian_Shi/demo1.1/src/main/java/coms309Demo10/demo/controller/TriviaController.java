package coms309Demo10.demo.controller;

import coms309Demo10.demo.repository.TriviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import coms309Demo10.demo.model.Trivia;

import java.util.List;

@RestController
public class TriviaController {

    @Autowired
    TriviaRepository triviaRepository;

    @GetMapping("trivia/all")
    List<Trivia> GetAllTrivias(){
        return triviaRepository.findAll();
    }

    @PostMapping("trivia/post/{q}/{a}")
    Trivia PostTriviaByPath(@PathVariable String q, @PathVariable String a){
        Trivia newTrivia = new Trivia();
        newTrivia.setQuestion(q);
        newTrivia.setAnswer(q);
        triviaRepository.save(newTrivia);
        return newTrivia;
    }

    @PostMapping("trivia/post")
    Trivia PostTriviaByPath(@RequestBody Trivia newTrivia){
        triviaRepository.save(newTrivia);
        return newTrivia;
    }
}
