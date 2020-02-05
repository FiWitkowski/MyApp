package com.example.myapp.LayoutHandle;

import com.example.myapp.Misc.Grade;
import com.example.myapp.Misc.Subject;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.Teacher;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;

public class MainController implements MainControllerService {
    private static MainController m;
    private Reader reader;
    private Writer writer;

    public static MainController getInstance(){
        if(m==null){
            m=new MainController();
            return m;
        }
        else return m;
    }

    public MainController(){
        reader=new Reader();
        writer=new Writer();
    }


    public ArrayList<Parent> getListOfParents(Student student){
        return null;
    }

    public ArrayList<Student> getListOfStudents(Parent parent){
        return reader.getListOfStudents(parent);
    }

    public ArrayList<Student> getListOfStudents(Class sc){
        return reader.getListOfStudents(sc);
    }

    public ArrayList<Subject> getListOfSubjects(Student pupil){
        return reader.getListOfSubjects(pupil);
    }

    public ArrayList<Grade> getListOfGrades(Student pupil, Subject subject){
        return reader.getListOfGrades(pupil,subject);
    }

    public Map<Class,Subject> getListOfClassesAndSubjects(Teacher teacher){
        return reader.getListOfClassesAndSubjects(teacher);
    }

    public boolean isAParent(Teacher t) {
        return reader.isAParent(t);
    }

    public void addGrade(Grade grade){
        writer.addGrade(grade);
    }

    public void deleteGrade(Grade grade){
        writer.deleteGrade(grade);
    }

    public void updateGrade(Grade oldG, Grade newG){
        writer.updateGrade(oldG,newG);
    }


    public static void main(String[] args) {
//        System.out.println(getInstance().getListOfStudents(new Parent(37,null,null,null,null,null)));
//        System.out.println(getInstance().getListOfSubjects(new Student(1,null,null,null,null,null,null,null)));
//        System.out.println(getInstance().getListOfGrades(new Student(1,null,null,null,null,null,null,null),
//                new Subject("Matematyka")));
//        System.out.println(getInstance().getListOfClassesAndSubjects(new Teacher(52,null,null,null,null,null,null)));
//        System.out.println(getInstance().getListOfStudents(new SchoolClass("1a",null)));
//        getInstance().addGrade(new Grade(new Student(1,null,null,null,null,null,null,null),
//                5,new Subject("Matematyka",1),null, "krtk"));
//        getInstance().deleteGrade(new Grade(122,null,0,null,null,null,null));
//         getInstance().updateGrade(new Grade(120,null,0,null,null,null,null),
//                 new Grade(null, 6,null,null,"krtk"));

    }

}
