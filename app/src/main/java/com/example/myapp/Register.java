package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapp.R;

public class Register extends AppCompatActivity implements View.OnClickListener {

    TextView tvSpinner;
    Button buttonRegister;
    EditText etFirstName,etLastName, etUsername,etPassword,etPasswordC;
    Spinner spAccess;
    String[] accessLevels = {"Student","Parent","Teacher"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordC = (EditText) findViewById(R.id.etPasswordC);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        tvSpinner = (TextView) findViewById(R.id.tvSpinner);
        Spinner spAccess = (Spinner) findViewById(R.id.spAccess);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,accessLevels);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAccess.setAdapter(arrayAdapter);

        spAccess.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch(position){
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonRegister:
                startActivity(new Intent(this,Login.class));
                break;
        }
    }
}
