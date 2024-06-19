package com.graphrefresh.graphql.repositories;

import com.graphrefresh.graphql.db.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
