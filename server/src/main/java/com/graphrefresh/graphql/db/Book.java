package com.graphrefresh.graphql.db;

import jakarta.persistence.*;




@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int pageCount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;

    // Default constructor
    public Book() {
    }

//    public Book(String name, int pageCount, Author author) {
//        this.name = name;
//        this.pageCount = pageCount;
//        this.author = author;
//    }
//
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPageCount() {
        return this.pageCount;
    }
//
//    public Author getAuthor() {
//        return this.author;
//    }
}