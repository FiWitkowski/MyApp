package com.example.myapp.Users;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {
    public static final String SP_NAME="userDetails";
    SharedPreferences userLocalDatabase;
    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("firstName",user.firstName);
        spEditor.putString("lastName",user.lastName);
        spEditor.putString("userName",user.getUserName());
        spEditor.putString("password",user.getPassword());
        spEditor.putString("dateOfBirth",user.dateOfBirth.toString());
        spEditor.putString("email",user.emailAddress.toString());
        spEditor.putInt("age",user.age);
        spEditor.commit();

    }
    public User getLoggedInUser(){
        String firstName = userLocalDatabase.getString("firstName","");
        String lastName = userLocalDatabase.getString("lastName","");
        String userName = userLocalDatabase.getString("userName","");
        String password = userLocalDatabase.getString("password","");

        int age = userLocalDatabase.getInt("age",-1);

        AccessLevel typeOfUser =AccessLevel.valueOf(userLocalDatabase.getString("typeOfUser",""));
        User storedUser;
        switch(typeOfUser){
            case STUDENT:
                storedUser = new Student(firstName, lastName, userName, password);
                return storedUser;

        }
        return storedUser = new Admin(firstName,lastName,userName,password);
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("loggedIn",false)==true)
            return true;
        else
            return false;
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
