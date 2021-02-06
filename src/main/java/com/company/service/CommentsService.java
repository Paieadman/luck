package com.company.service;

import com.company.entity.Comment;
import com.company.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentsService {

    @Autowired
    private CommentRepository commentRepository;

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> getComments() {
        Iterable<Comment> iterableComments = commentRepository.findAll();
        List<Comment> comments = new ArrayList<Comment>();
        iterableComments.forEach((com) -> {
            comments.add(com);
        });
        return comments;
    }
}
