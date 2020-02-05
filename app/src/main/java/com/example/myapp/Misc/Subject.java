package com.example.myapp.Misc;

import com.example.myapp.Users.Teacher;

import java.io.Serializable;

public class Subject implements Serializable {
    private String name;
    private Teacher id;

    public Subject(String name){
        this.name=name;
    }

    public Subject(String name, Teacher id)
    {
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return id;
    }

    @Override
    public String toString(){
        return name;
    }
}

