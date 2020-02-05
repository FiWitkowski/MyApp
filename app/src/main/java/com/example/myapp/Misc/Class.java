package com.example.myapp.Misc;

import android.annotation.TargetApi;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.Users.Student;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.List;

public class Class {

    public String className;
    public List<Student> listStudents=new LinkedList<Student>();

    public Class(String className) {

        this.listStudents = new ArrayList<Student>();

        this.className=className;
    }

    double SredniaOcen(){
        return 0;
    }

    public void AddStudent(Student student){
        listStudents.add(student);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void DeleteStudent(String userName){
        listStudents.stream().filter(student -> student.getUserName().equals(userName));
        listStudents.removeIf(student -> student.getUserName().equals(userName));
    }
    public String getClassName() {
        return className;
    }
}
