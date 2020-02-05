package com.example.myapp.Users;

import com.example.myapp.LayoutHandle.Register;

import java.util.List;

public class Teacher extends User {
    private List<Student> children;
    public Teacher(String userName, String password, String firstName, String lastName, int age, String emailAddress, AccessLevel typeOfUser){
        super(userName, password, firstName, lastName, age, emailAddress, typeOfUser);
    }
    public List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }

    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
