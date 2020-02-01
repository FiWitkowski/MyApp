package com.example.myapp.Users;

public class Admin extends User {
    private static final Admin instance = new Admin();

    public Admin(String firstName, String lastName, String userName, String password) {
        this();
    }

    private Admin(){
       userName="admin";
       password="admin";
    }
    public static final Admin getInstance(){

        return instance;
    }

    public void ChangePassword(String newPassword){
        instance.password=newPassword;
    }
    public void ChangeUsername(String newUsername){
        instance.userName=newUsername;
    }


}
