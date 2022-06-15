package backend.categories.controller;

import backend.categories.model.Comment;
import backend.categories.repository.CommentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController  {
    @Autowired
    CommentRepository commentRepository;


    @GetMapping("Comment/info")
    List<Comment> GetAllComment(){
        return commentRepository.findAll();
    }

    @PostMapping("Comment/post")
    Comment CommentByPath(@RequestBody Comment newComment){
        commentRepository.save(newComment);
        return newComment;
    }
}
