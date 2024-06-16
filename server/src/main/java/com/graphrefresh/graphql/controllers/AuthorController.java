package com.graphrefresh.graphql.controllers;

import com.graphrefresh.graphql.db.Author;
import com.graphrefresh.graphql.inputs.AuthorInput;
import com.graphrefresh.graphql.repositories.AuthorRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public Optional<Author> authorById(@Argument Integer id) {
        return authorRepository.findById(id);
    }

    @MutationMapping
    public Author addAuthor(@Argument("author") AuthorInput authorInput) {
        Author author = new Author(authorInput.getFirstName(), authorInput.getLastName());
        return authorRepository.save(author);
    }
}
