package com.example.myapp.LayoutHandle;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.myapp.DataBases.ClassDB;
import com.example.myapp.DataBases.UserDB;
import com.example.myapp.Misc.Class;
import com.example.myapp.Misc.Subject;
import com.example.myapp.R;
import com.example.myapp.TeacherActivity.TeacherMainActivity;
import com.example.myapp.Users.Admin;
import com.example.myapp.Users.CurrentUser;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.Teacher;
import com.example.myapp.Users.User;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
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
                        CurrentUser.setUser(Admin.getInstance());
                        startActivity(new Intent(this,AdminPanel.class));
                        break;
                    }
                    //region presentation objects
                    Class b1= new Class("1b");
                    Class a2= new Class("2a");
                    ClassDB.addClass(a2);
                    ClassDB.addClass(b1);

                    Student s1 = new Student("student1", "student1", "Ola", "Kralka", 13, "pimpon@onet.pl", "1b");
                    Student s2 = new Student("student2", "student2", "Iza", "Krawczyk", 12, "pimpon2@onet.pl", "1b");
                    Student s3 = new Student("student3", "student3", "Filip", "Witkowski", 14, "pimpon333@onet.pl", "2a");
                    Student s4 = new Student("student4", "student4", "Marcin", "Żyrkowski", 13, "pimpooon@onet.pl", "1b");
                    Student s5 = new Student("student5", "student5", "Pimpon", "Pimponowski", 14, "pimpon@onet.pl", "2a");

                    Parent p1 = new Parent("parent1","parent1","Kralek","Krawczyk", 99,"rodzic@interia.pl",s1);
                    Parent p2 = new Parent("parent2", "parent2", "Andrzej", "Kralka", 41, "hej.jestem.andrzej@gmail.com", s1);
                    Parent p3 = new Parent("parent3", "parent3", "Halinka", "Witkowska", 45, "lubie_kluski@gmail.com", s3);
                    Parent p4 = new Parent("parent4", "parent4", "Alutka", "Zyrkowska", 47, "alinkaaa@gmail.com", s4);
                    Parent p5 = new Parent("parent5", "parent5", "Janusz", "Pimponowski", 36, "pimponowski@gmail.com", s5);

                    s1.parent=p1;
                    s2.parent=p2;
                    s3.parent=p3;
                    s4.parent=p4;
                    s5.parent=p5;

                    UserDB.addUser(p1);
                    UserDB.addUser(p2);
                    UserDB.addUser(p3);
                    UserDB.addUser(p4);
                    UserDB.addUser(p5);

                    Teacher t1 = new Teacher("teacher1", "teacher1", "Teresa", "Kowalska", 59, "tereska@o2.pl");
                    Teacher t2 = new Teacher("teacher2", "teacher2", "Bogdan", "Kowalski", 28, "jestem.bogus@o2.pl");

                    List<Integer> listaOcen1=new ArrayList<Integer>();
                    List<Integer> listaOcen2=new ArrayList<Integer>();
                    List<Integer> listaOcen3=new ArrayList<Integer>();

                    listaOcen2.add(3);
                    listaOcen2.add(4);
                    listaOcen2.add(5);
                    listaOcen3.add(3);
                    listaOcen3.add(2);
                    listaOcen3.add(6);
                    listaOcen1.add(1);
                    listaOcen1.add(4);
                    listaOcen1.add(5);
                    listaOcen1.add(4);

                    s1.grades.put(new Subject("matematyka",t1),listaOcen2);
                    s1.grades.put(new Subject("informatyka",t2),listaOcen3);
                    s2.grades.put(new Subject("matematyka",t1),listaOcen1);
                    s2.grades.put(new Subject("WF",t2),listaOcen2);
                    s3.grades.put(new Subject("fizyka",t1),listaOcen3);
                    s3.grades.put(new Subject("historia",t2),listaOcen1);
                    s4.grades.put(new Subject("matematyka",t1),listaOcen2);
                    s4.grades.put(new Subject("WOS",t2),listaOcen3);
                    s5.grades.put(new Subject("matematyka",t1),listaOcen1);
                    s5.grades.put(new Subject("historia",t2),listaOcen2);
                    s5.grades.put(new Subject("WF",t2),listaOcen3);


                    UserDB.addUser(t1);
                    UserDB.addUser(t2);
                    UserDB.addUser(s1);
                    UserDB.addUser(s2);
                    UserDB.addUser(s3);
                    UserDB.addUser(s4);
                    UserDB.addUser(s5);
                    //endregion


                    User user = UserDB.getInstance().searchUser(etUsername.getText().toString());
                    if(user!=null){
                         if(user.getPassword().equals(etPassword.getText().toString())){
                            CurrentUser.setUser(user);
                            switch(user.typeOfUser){
                                case STUDENT:
                                    startActivity(new Intent(this, StudentMainActivity.class));
                                    break;
                                case TEACHER:
                                    startActivity(new Intent(this, TeacherMainActivity.class));
                                    break;
                                case PARENT:
                                    startActivity(new Intent(this,ParentActivity.class));
                                    break;
                                case PRINCIPAL:
                                    break;
                                case LIBRARY_ASSISTANT:
                                    break;
                                default:
                                    break;
                            }
                         }
                    }
                        break;
                case R.id.tvRegisterLink:
                    startActivity(new Intent(this, Register.class));
                    break;
             }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
