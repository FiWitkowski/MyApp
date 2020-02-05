package com.example.myapp.LayoutHandle;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.myapp.DataBases.ClassDB;
import com.example.myapp.DataBases.UserDB;
import com.example.myapp.MainApp;
import com.example.myapp.Misc.Grade;
import com.example.myapp.Misc.Subject;
import com.example.myapp.R;
import com.example.myapp.Users.Admin;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;
import com.example.myapp.Misc.Class;
import com.example.myapp.Users.Teacher;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button buttonLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;
    UserDB userDB = UserDB.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        tvRegisterLink=(TextView) findViewById(R.id.tvRegisterLink);
        buttonLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
    }




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        try{
            switch (v.getId()) {
                case R.id.buttonLogin:

                    if(etUsername.getText().toString().equals("admin")&&
                            etPassword.getText().toString().equals("admin")) {
                        startActivity(new Intent(this,AdminPanel.class));
                        break;
                    }


                    //need change

                    //User user = new Student("", "", "", "",-1,1,1));

                    startActivity(new Intent(this, MainApp.class));
                    break;
                case R.id.tvRegisterLink:
                    startActivity(new Intent(this, Register.class));
                    break;
             }
        }
        catch(Exception e){
            throw e;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void createSchool(){
        Student s1 = new Student("pimpon", "pimpoon", "Ola", "Kralka", 13, "pimpon@onet.pl", "1b");
        Student s2 = new Student("pimpon2", "pimpoon2", "Iza", "Krawczyk", 12, "pimpon2@onet.pl", "1b");
        Student s3 = new Student("pimpon3", "pimpoon3", "Filip", "Witkowski", 14, "pimpon333@onet.pl", "2a");
        Student s4 = new Student("pimpon4", "pimpoon4", "Marcin", "Żyrkowski", 13, "pimpooon@onet.pl", "1b");
        Student s5 = new Student("pimpon5", "pimpoon5", "Pimpon", "Pimponowski", 14, "pimpon@onet.pl", "2a");

        List<Student> listStudents1b = new ArrayList<Student>();
        List<Student> listStudents2a = new ArrayList<Student>();
        listStudents1b.add(s1);
        listStudents1b.add(s2);
        listStudents1b.add(s4);
        listStudents2a.add(s3);
        listStudents2a.add(s5);

        Class a2= new Class("2a", listStudents2a);
        Class b1= new Class("1b", listStudents1b);

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

        UserDB.addUser(s1);
        UserDB.addUser(s2);
        UserDB.addUser(s3);
        UserDB.addUser(s4);
        UserDB.addUser(s5);

        UserDB.addUser(t1);
        UserDB.addUser(t2);

        UserDB.addUser(p1);
        UserDB.addUser(p2);
        UserDB.addUser(p3);
        UserDB.addUser(p4);
        UserDB.addUser(p5);

        ClassDB.addClass(a2);
        ClassDB.addClass(b1);
    }


}