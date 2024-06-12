package com.graphrefresh.graphql.controllers;

import com.graphrefresh.graphql.db.Employee;
import com.graphrefresh.graphql.repositories.EmployeeRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @QueryMapping
    public Optional<Employee> employeeById(@Argument Integer id) { return this.employeeRepository.findById(id); }

    @QueryMapping
    public Iterable<Employee> employees() {return this.employeeRepository.findAll();}
}
