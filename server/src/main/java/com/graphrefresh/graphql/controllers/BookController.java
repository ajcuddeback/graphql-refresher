package com.graphrefresh.graphql.controllers;

import com.graphrefresh.graphql.db.Book;
import com.graphrefresh.graphql.repositories.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @QueryMapping
    public Optional<Book> bookById(@Argument Integer id) {
        return bookRepository.findById(id);
    }
}