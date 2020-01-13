package com.example.myapp.Users;

public class Admin extends User {
    public Admin(String userName,String password){
        super("","",userName,password);
    }
    public Admin(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);
    }
}
