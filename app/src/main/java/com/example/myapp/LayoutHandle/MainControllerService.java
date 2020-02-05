package com.example.myapp.LayoutHandle;

import com.example.myapp.Misc.Grade;
import com.example.myapp.Misc.Subject;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.Teacher;

import java.util.ArrayList;
import java.util.Map;

interface MainControllerService {
    public ArrayList<Parent> getListOfParents(Student student);
    public ArrayList<Student> getListOfStudents(Parent parent);
    public ArrayList<Student> getListOfStudents(Class schoolClass);
    public ArrayList<Subject> getListOfSubjects(Student Student);
    public ArrayList<Grade> getListOfGrades(Student pupil, Subject subject);
    public Map<Class,Subject> getListOfClassesAndSubjects(Teacher teacher);
    public boolean isAParent(Teacher t);
    public void addGrade(Grade grade);
    public void deleteGrade(Grade grade);
    public void updateGrade(Grade oldG,Grade newG);
}
