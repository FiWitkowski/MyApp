package com.example.myapp.LayoutHandle;

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
import com.example.myapp.Users.AccessLevel;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.User;

public class Register extends AppCompatActivity implements View.OnClickListener {

    TextView tvSpinner;
    Button buttonRegister;
    EditText etFirstName,etLastName, etUsername,etPassword,etPasswordC;
    Spinner spAccess;
    String[] accessLevels = {"Student","Parent","Teacher"};
    AccessLevel typeOfUser;

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
                            typeOfUser=AccessLevel.STUDENT;
                            break;
                        case 1:
                            typeOfUser=AccessLevel.PARENT;
                            break;
                        case 2:
                            typeOfUser=AccessLevel.TEACHER;
                            break;
                }
            }
        //Trzeba to jakos zrobic
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                try {
                    throw new UserTypeNotDefinedException();
                } catch (UserTypeNotDefinedException e) {
                    e.printStackTrace();
                }
            }
        });
        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!etPassword.getText().toString().equals(etPasswordC.getText().toString())) {
            //POKAZ WIADOMOSC ZE SIE HASLA NIE ZGADZAJA
            return;
        }
        switch (v.getId()){

            case R.id.buttonRegister:
                switch(typeOfUser){
                    case STUDENT:
                        String firstName = etFirstName.getText().toString();
                        String lastName = etLastName.getText().toString();
                        String userName = etUsername.getText().toString();
                        String password = etPassword.getText().toString();
//                        User registeredData = new Student(firstName,lastName,userName,password);
                }
                startActivity(new Intent(this,Login.class));
                break;
        }
    }
}
