package com.graphrefresh.graphql.controllers;

import com.graphrefresh.graphql.db.Author;
import com.graphrefresh.graphql.db.Book;
import com.graphrefresh.graphql.inputs.BookInput;
import com.graphrefresh.graphql.repositories.AuthorRepository;
import com.graphrefresh.graphql.repositories.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    @QueryMapping
    public Optional<Book> bookById(@Argument Integer id) {
        return bookRepository.findById(id);
    }

    @MutationMapping
    public Book addBook(@Argument("book") BookInput bookInput) {
        Author author = authorRepository.findById(bookInput.getAuthor())
                .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + bookInput.getAuthor()));
        Book book = new Book(bookInput.getName(), bookInput.getPageCount(), author);
        return bookRepository.save(book);
    }
}