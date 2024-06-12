package com.graphrefresh.graphql.repositories;

import com.graphrefresh.graphql.db.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {}
