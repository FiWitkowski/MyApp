package com.example.myapp.Users;

import android.provider.ContactsContract;

import java.util.Date;

public abstract class User {
    private String userName;
    private String password;
    public String firstName, lastName;
    public int age;
    public Date dateOfBirth;
    public ContactsContract.CommonDataKinds.Email emailAddress;
    public AccessLevel typeOfUser;


    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }
        final public String getUserName(){
            return this.userName;
        }
        final public String getPassword(){
        return this.password;
    }


}
