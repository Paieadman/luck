package com.company.controller;

import com.company.entity.Comment;
import com.company.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @RequestMapping("/comments")
    public List<Comment> getComments() {
        return commentsService.getComments();
    }

    @PostMapping("/comments/add")
    public void addComment(@RequestBody Comment comment) {
        commentsService.addComment(comment);
    }
}
