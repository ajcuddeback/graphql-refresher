package com.graphrefresh.graphql.inputs;

public class AuthorInput {
    private String firstName;
    private String lastName;

    public AuthorInput() {}

    public String getFirstName() {return this.firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return this.lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
}
