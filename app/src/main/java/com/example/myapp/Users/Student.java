package com.example.myapp.Users;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.DataBases.ClassDB;
import com.example.myapp.DataBases.UserDB;
import com.example.myapp.Misc.Book;
import com.example.myapp.Misc.Class;
import com.example.myapp.Misc.Subject;

import java.util.List;
import java.util.Map;

public class Student extends User {

    public Class myClass;
    public Map<Subject, List<Integer>> grades;
    public Parent parent;
    public List<Book> books;


    public Student(String userName, String password){
        this(userName,password,"","",-1,"");
    }
    public Student(String userName, String password, String firstName, String lastName,
                   int age, String emailAddress) {
        super(userName, password, firstName, lastName, age, emailAddress,AccessLevel.STUDENT);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Student(String userName, String password, String firstName, String lastName,
                   int age, String emailAddress, String className){
        this(userName,password,firstName,lastName,age,emailAddress);
        myClass = ClassDB.getInstance().searchClass(className);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Student(String userName, String password, String firstName, String lastName,
                   int age, String emailAddress, String parentUserName, String className){
     this(userName,password,firstName,lastName,age,emailAddress,className);

        parent = (Parent) UserDB.getInstance().searchUser(parentUserName);

        }


    }

