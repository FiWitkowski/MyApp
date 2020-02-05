package com.example.myapp.Users;


public abstract class User {
    protected String userName;
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

    final public String getUserName(){
            return this.userName;
        }
        final public String getPassword(){
        return this.password;
    }


}
