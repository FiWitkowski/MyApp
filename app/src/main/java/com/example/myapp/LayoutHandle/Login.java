package com.example.myapp.LayoutHandle;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.myapp.DataBases.UserDB;
import com.example.myapp.MainApp;
import com.example.myapp.R;
import com.example.myapp.Users.Admin;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.User;
import com.example.myapp.Users.UserLocalStore;


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
    UserLocalStore userLocalStore;
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
        userLocalStore=new UserLocalStore(this);
    }




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        try{
            switch (v.getId()) {
                case R.id.buttonLogin:
                    userLocalStore.clearUserData();
                    userLocalStore.setUserLoggedIn(true);
                    if(etUsername.getText().toString().equals("admin")&&
                            etPassword.getText().toString().equals("admin")) {
                        userLocalStore.storeUserData(Admin.getInstance());
                        startActivity(new Intent(this,AdminPanel.class));
                        break;
                    }


                    //need change


                    User user = new Student("", "", "", "",-1,new Date(1,1,1),"");
                    userLocalStore.storeUserData(user);
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
}
