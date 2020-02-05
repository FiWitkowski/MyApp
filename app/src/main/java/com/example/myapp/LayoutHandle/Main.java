package com.example.myapp.LayoutHandle;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.Misc.Class;
import com.example.myapp.Misc.Grade;
import com.example.myapp.Misc.Subject;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Main {


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String []args){




        Class a2= new Class("2a");
        Class b1= new Class("1b");

        Student s1 = new Student("pimpon", "pimpoon", "Ola", "Kralka", 13, "pimpon@onet.pl", "1b");
        Student s2 = new Student("pimpon2", "pimpoon2", "Iza", "Krawczyk", 12, "pimpon2@onet.pl", "1b");
        Student s3 = new Student("pimpon3", "pimpoon3", "Filip", "Witkowski", 14, "pimpon333@onet.pl", "2a");
        Student s4 = new Student("pimpon4", "pimpoon4", "Marcin", "Żyrkowski", 13, "pimpooon@onet.pl", "1b");
        Student s5 = new Student("pimpon5", "pimpoon5", "Pimpon", "Pimponowski", 14, "pimpon@onet.pl", "2a");


        Teacher t1 = new Teacher("nauczyciel1", "kochamdzieci123", "Teresa", "Kowalska", 59, "tereska@o2.pl");
        Teacher t2 = new Teacher("nauczyciel2", "niekochamdzieci", "Bogdan", "Kowalski", 28, "jestem.bogus@o2.pl");

        Subject sub1= new Subject("matematyka", t1);
        Subject sub2= new Subject("wf", t2);

        Grade g1 = new Grade(s1, 2, sub1);
        Grade g2 = new Grade(s2, 5, sub2);
        Grade g3 = new Grade(s3, 3, sub2);
        Grade g4 = new Grade(s4, 3, sub1);
        Grade g5 = new Grade(s5, 2, sub2);
        Grade g6 = new Grade(s1, 1, sub1);
        Grade g7 = new Grade(s2, 2, sub1);
        Grade g8 = new Grade(s3, 3, sub2);
        Grade g9 = new Grade(s4, 4, sub1);
        Grade g10 = new Grade(s5, 2, sub2);

        Parent p1 = new Parent("mamaBabelka", "bombelek", "Grażyna", "Krawczyk", 40, "grazynka@gmail.com", s2);
        Parent p2 = new Parent("tata1", "bombelek", "Andrzej", "Kralka", 41, "hej.jestem.andrzej@gmail.com", s1);
        Parent p3 = new Parent("mama2", "MOJbombelek", "Halinka", "Witkowska", 45, "lubie_kluski@gmail.com", s3);
        Parent p4 = new Parent("mama3", "NieMOJbombelek", "Alutka", "Zyrkowska", 47, "alinkaaa@gmail.com", s4);
        Parent p5 = new Parent("tata8", "kabum123", "Janusz", "Pimponowski", 36, "pimponowski@gmail.com", s5);



    }



}
