package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapp.R;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button buttonLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogin:
                startActivity(new Intent(this,MainApp.class));
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this,Register.class));
                break;

        }
    }
}
