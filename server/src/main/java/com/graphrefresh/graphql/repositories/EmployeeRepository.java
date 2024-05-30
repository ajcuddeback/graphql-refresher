package com.graphrefresh.graphql.repositories;

import com.graphrefresh.graphql.db.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {}

