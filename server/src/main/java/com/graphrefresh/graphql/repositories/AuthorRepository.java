package com.graphrefresh.graphql.repositories;

import com.graphrefresh.graphql.db.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
