package coms309Demo10.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDemo {
    @GetMapping("/")
    public String index() {
        return "Here is my Demo#1";
    }
}
