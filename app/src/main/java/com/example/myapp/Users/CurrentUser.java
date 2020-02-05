package com.example.myapp.Users;

public class CurrentUser {
    private static User instance=null;

    private void CurrentUse(){};

    public static User getUser(){
        return instance;
    }

    public static void setUser(User user){
        instance = user;
    }

}
