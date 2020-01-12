package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Settings extends AppCompatActivity implements View.OnClickListener{

    Button buttonChangePassword;
    EditText etNewPassword,etNewPasswordC, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        etNewPassword = (EditText) findViewById(R.id.etNewPassword);
        etNewPasswordC = (EditText) findViewById(R.id.etNewPasswordC);
        etPassword = (EditText) findViewById(R.id.etPassword);
        buttonChangePassword = (Button) findViewById(R.id.buttonChangePassword);
        buttonChangePassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonChangePassword:
                //Logika zmiany hasla
                startActivity(new Intent(this,MainApp.class));
                break;

        }
    }
}
