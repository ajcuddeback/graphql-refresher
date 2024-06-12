package com.graphrefresh.graphql.db;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="author")
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;

    // Default constructor
    public Author() {
    }

//    public Author(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
    public Integer getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
//    public List<Book> getBooks() {return this.books;}
//    public void setBooks(List<Book> books) { this.books = books; }
}