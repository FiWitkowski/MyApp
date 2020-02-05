package com.example.myapp.LayoutHandle;

import android.annotation.TargetApi;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.Misc.Class;
import com.example.myapp.Misc.Grade;
import com.example.myapp.Misc.Subject;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.Teacher;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    private static MainController m;

    public static MainController getInstance(){
        if(m==null){
            m=new MainController();
            return m;
        }
        else return m;
    }

    public MainController(){
    }
    public ArrayList<Parent> getListOfParents(Student student){
        return null;
    }

    public ArrayList<Student> getListOfStudents(java.lang.Class parent){
        return new ArrayList<Student>();
    }

    public ArrayList<Student> getListOfStudents(Class sc){
        return new ArrayList<Student>();
    }

    public ArrayList<Subject> getListOfSubjects(Student pupil){
        return new ArrayList<Subject>();
    }

    public ArrayList<Grade> getListOfGrades(Student pupil, Subject subject){
        return new ArrayList<Grade>();
    }

    public Map<Class,Subject> getListOfClassesAndSubjects(Teacher teacher){
        return new HashMap<Class, Subject>();
    }

    public boolean isAParent(Teacher t) {
        return true;
    }

    public void addGrade(Grade grade){

    }

    public void deleteGrade(Grade grade){

    }

    public void updateGrade(Grade oldG, Grade newG){
    }



}