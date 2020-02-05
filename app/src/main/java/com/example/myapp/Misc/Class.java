package com.example.myapp.Misc;

import android.annotation.TargetApi;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.Users.Student;

import java.util.List;

public class Class {

    public String className;
    public List<Student> listStudents;

    public Class(String className, List<Student> listStudents) {
        this.listStudents = listStudents;
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
