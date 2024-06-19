package com.graphrefresh.graphql.controllers;

import com.graphrefresh.graphql.db.Comment;
import com.graphrefresh.graphql.db.Employee;
import com.graphrefresh.graphql.inputs.CommentInput;
import com.graphrefresh.graphql.repositories.CommentRepository;
import com.graphrefresh.graphql.repositories.EmployeeRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {
    private final CommentRepository commentRepository;
    private final EmployeeRepository employeeRepository;

    public CommentController(CommentRepository commentRepository, EmployeeRepository employeeRepository) {
        this.commentRepository = commentRepository;
        this.employeeRepository = employeeRepository;
    }

    @QueryMapping
    public Comment commentById(@Argument Integer id) {
        return commentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Comment not found with id: " + id));
    }
    @QueryMapping
    public Iterable<Comment> comments() {
        return commentRepository.findAll();
    }

    @MutationMapping
    public Comment addComment(@Argument("comment") CommentInput commentInput) {
        Employee employee = employeeRepository.findById(commentInput.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + commentInput.getEmployeeId()));
        Comment comment = new Comment(employee, commentInput.getComment());
        if(commentInput.getParentId() != null) {
            Comment parentComment = commentRepository.findById(commentInput.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent comment not found with id: " + commentInput.getParentId()));
            comment.setParent(parentComment);
        }

        return commentRepository.save(comment);
    }
}
