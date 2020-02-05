package com.example.myapp.LayoutHandle;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.myapp.DataBases.UserDB;
import com.example.myapp.MainApp;
import com.example.myapp.R;
import com.example.myapp.Users.Admin;
import com.example.myapp.Users.CurrentUser;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.User;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

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

                    UserDB.addUser(new Parent("parent","parent","Kralek","Krawczyk",
                            99,"rodzic@interia.pl"));


                    //need change
                    User user = UserDB.getInstance().searchUser(etUsername.getText().toString());
                    if(user!=null){
                         if(user.getPassword().equals(etPassword.getText().toString())){
                            CurrentUser.setUser(user);
                            switch(user.typeOfUser){
                                case STUDENT:
                                    break;
                                case TEACHER:
                                    break;
                                case PARENT:
                                    startActivity(new Intent(this,ParentActivity.class));
                                    break;
                                case PRINCIPAL:
                                    break;
                                case LIBRARY_ASSISTANT:
                                    break;
                                default:
                                    startActivity(new Intent(this,MainApp.class));
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
            throw e;
        }
    }
}
