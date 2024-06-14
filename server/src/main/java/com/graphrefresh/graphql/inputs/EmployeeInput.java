package com.graphrefresh.graphql.inputs;

public class EmployeeInput {
    private String firstName;
    private String lastName;

    public EmployeeInput() {}

    public String getFirstName() { return this.firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return this.lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
}
