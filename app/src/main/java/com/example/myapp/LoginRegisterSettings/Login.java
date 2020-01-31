package com.example.myapp.LoginRegisterSettings;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapp.MainApp;
import com.example.myapp.R;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.User;
import com.example.myapp.Users.UserLocalStore;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button buttonLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;
    UserLocalStore userLocalStore;

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
        userLocalStore=new UserLocalStore(this);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogin:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(true);
                //need change
                User user = new Student("","","","");
                userLocalStore.storeUserData(user);
                startActivity(new Intent(this, MainApp.class));
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this,Register.class));
                break;

        }
    }
}
