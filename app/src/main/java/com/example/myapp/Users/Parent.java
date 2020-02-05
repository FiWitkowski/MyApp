package com.example.myapp.Users;

import android.os.Build;

import androidx.annotation.RequiresApi;
import com.example.myapp.DataBases.UserDB;
import com.example.myapp.Misc.Subject;

import java.io.Serializable;
import java.util.List;

public class Parent extends User implements Serializable {
    public String childUserName;

    public Parent(String userName, String password){
        this(userName,password,"","",-1,"");
    }
    public Parent(String userName, String password, String firstName,
                  String lastName,int age,String emailAddress) {
        super(userName, password, firstName, lastName, age, emailAddress,AccessLevel.PARENT);
    }

    public Parent(String userName, String password, String firstName, String lastName,
                  int age, String emailAddress, Student child){
        this(userName,password,firstName,lastName,age,emailAddress);
        childUserName=child.userName;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Integer> checkGrades(Subject subject){
        return ((Student)UserDB.getInstance().searchUser(childUserName)).grades.get(subject);
    }



}
