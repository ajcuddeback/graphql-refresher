package com.graphrefresh.graphql.inputs;

public class BookInput {
    private String name;
    private int pageCount;
    private int author;

    public BookInput() {}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getPageCount() {return pageCount;}
    public void setPageCount(int pageCount) {this.pageCount = pageCount;}
    public int getAuthor() {return author;}
    public void setAuthor(int author) {this.author = author;}
}
