package com.example.assignment2;

public class User {
    private String Name,pass;

    public User() {
    }

    public User(String name, String pass) {
        Name = name;
        this.pass = pass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



}
