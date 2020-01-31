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

        //spEditor.putString("typeOfUser",user.typeOfUser.ToString());
        spEditor.commit();

    }

    public User getLoggedInUser(){
        //Polowa tych zmiennych nie ma znaczenia
        String firstName = userLocalDatabase.getString("firstName","");
        String lastName = userLocalDatabase.getString("lastName","");
        String userName = userLocalDatabase.getString("userName","");
        String password = userLocalDatabase.getString("password","");
        String email = userLocalDatabase.getString("email","");
        String dateOfBirth = userLocalDatabase.getString("dateOfBirth","");
        int age = userLocalDatabase.getInt("age",-1);

        //zamienic na wyszukiwanie
        User storedUser = new Student(firstName,lastName,userName,password);
        AccessLevel typeOfUser =AccessLevel.valueOf(userLocalDatabase.getString("typeOfUser",""));


        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        return userLocalDatabase.getBoolean("loggedIn",false);
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
