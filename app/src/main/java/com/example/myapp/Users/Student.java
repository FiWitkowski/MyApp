package com.example.myapp.Users;

import android.annotation.TargetApi;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.DataBases.ClassDB;
import com.example.myapp.DataBases.UserDB;
import com.example.myapp.Misc.Book;
import com.example.myapp.Misc.Class;
import com.example.myapp.Misc.Subject;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student extends User {

    public Class myClass;
    public Map<Subject, List<Integer>> grades=new HashMap<Subject, List<Integer>>();
    public Parent parent;
    public List<Book> books=new LinkedList<Book>();


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
        myClass.AddStudent(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Student(String userName, String password, String firstName, String lastName,
                   int age,  String emailAddress, String parentUserName, String className){
     this(userName,password,firstName,lastName,age,emailAddress,className);
        //this.parent=parent;
        this.parent = (Parent) UserDB.getInstance().searchUser(parentUserName);


    }


    public Subject getSubjectOfChild(String name){
        try {
            for (Subject s: grades.keySet()) {
                if(s.getName().equals(name)) return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


