package com.example.myapp.Users;

public class CurrentUser {
    private static User instance=null;

    private void CurrentUse(){};

    public User getUser(){
        return instance;
    }
    
    public void setUser(User user){
        instance = user;
    }

}
