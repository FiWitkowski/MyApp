package com.example.myapp.Misc;

import com.example.myapp.Users.Student;

import java.util.Date;


public class Grade {
    private Student student;
    private int value;
    private Subject subject;
    private Class sclass;
    private Date date;
    private int id;

    public Grade(Student student, int value, Subject subject, Class sclass, Date date){
        this.student=student;
        this.value=value;
        this.subject=subject;
        this.sclass=sclass;
    }


    public Grade(Student student, int value, Subject subject){
        this.student=student;
        this.value=value;
        this.subject=subject;
        this.date=new Date();
    }

    public Student getStudent() {
        return student;
    }

    public int getValue() {
        return value;
    }

    public Subject getSubject() {
        return subject;
    }

    public Class getSclass() {
        return sclass;
    }

    public Date getDate() {
        return date;
    }


    public int getId() {
        return id;
    }

    public static String weightParse(String t){
        switch(t){
            case "spr": return t;
            case "Sprawdzian": return "spr";
            case "odp": return t;
            case "Odpowiedź": return "odp";
            case "krtk": return t;
            case "Kartkówka": return "krtk";
            case "zad": return t;
            case "Zadanie": return "zad";
            default:return null;
        }
    }
    @Override
    public String toString(){
        return value+" ( "+date+")";
    }
}