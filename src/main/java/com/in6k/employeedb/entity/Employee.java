package com.in6k.employeedb.entity;

public class Employee {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String birhdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirhdate() {
        return birhdate;
    }

    public void setBirhdate(String birhdate) {
        this.birhdate = birhdate;
    }
}
