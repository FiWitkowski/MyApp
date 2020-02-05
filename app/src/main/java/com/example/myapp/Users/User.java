package com.example.myapp.Users;


public abstract class User {
    public String userName;
    protected String password;
    public String firstName, lastName;
    public int age;
    public String emailAddress;
    public AccessLevel typeOfUser;
    public User(){

    }

    public User(String userName, String password, String firstName, String lastName, int age, String emailAddress, AccessLevel typeOfUser) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;
        this.typeOfUser = typeOfUser;
    }
    public void setPassword(String password) {
        this.password = password;
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

    final public String getUserName(){
            return this.userName;
        }
        final public String getPassword(){
        return this.password;
    }
    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = emailAddress;
    }



}
