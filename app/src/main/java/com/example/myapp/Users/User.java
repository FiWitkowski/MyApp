package com.example.myapp.Users;

import android.provider.ContactsContract;

import java.util.Date;

public abstract class User {
    protected String userName;
    protected String password;
    public String firstName, lastName;
    public int age;
    public Date dateOfBirth;
    public String emailAddress;
    public AccessLevel typeOfUser;
    public User(){

    }

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.age=-1;
        this.dateOfBirth=new Date(1996,9,29);
        this.emailAddress  ="";
        typeOfUser = AccessLevel.STUDENT;
    }
        final public String getUserName(){
            return this.userName;
        }
        final public String getPassword(){
        return this.password;
    }


}
