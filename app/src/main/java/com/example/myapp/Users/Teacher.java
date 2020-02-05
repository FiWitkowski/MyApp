package com.example.myapp.Users;

import com.example.myapp.LayoutHandle.Register;

import java.util.LinkedList;
import java.util.List;

public class Teacher extends User {
    private List<Student> children=new LinkedList<>();
    public Teacher(String userName, String password, String firstName, String lastName, int age, String emailAddress){
        super(userName, password, firstName, lastName, age, emailAddress,AccessLevel.TEACHER);
    }
    public List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }

}