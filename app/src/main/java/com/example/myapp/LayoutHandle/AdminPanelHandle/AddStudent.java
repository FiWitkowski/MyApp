package com.example.myapp.LayoutHandle.AdminPanelHandle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.DataBases.UserDB;
import com.example.myapp.R;
import com.example.myapp.Users.Student;

public class AddStudent extends AppCompatActivity implements View.OnClickListener {

    Button btAddStudent,btGoBack;
    EditText etUserName, etPassword1,etPassword2,etFirstName,etLastName,etClass,etEmail,etDay,etMonth,etYear;

    UserDB userDB = UserDB.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        etUserName=findViewById(R.id.etUserNameAddStudent);
        etPassword1=findViewById(R.id.etPassword1AddStudent);
        etPassword2=findViewById(R.id.etPassword2AddStudent);
        etFirstName=findViewById(R.id.etFirstNameAddStudent);
        etLastName=findViewById(R.id.etLastName);
        etClass=findViewById(R.id.etClassAddStudent);
        etEmail=findViewById(R.id.etEmailAddStudent);
        etDay=findViewById(R.id.etDayAddStudent);
        etMonth=findViewById(R.id.etMonthAddStudent);
        etYear=findViewById(R.id.etYearAddStudent);
        btAddStudent=findViewById(R.id.btAddStudent2);
        btGoBack=findViewById(R.id.btGoBackAddStudent);

        btAddStudent.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btGoBack.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
      try{
          switch (v.getId()){
              case R.id.btAddStudent2:
                  //logic
                  if(etPassword1.getText()!=etPassword2.getText())
                      throw(new Exception("Passwords don't match"));
                  userDB.addUser(new Student(etUserName.getText().toString(),etPassword1.getText().toString()));
                  break;
              case R.id.btGoBackAddStudent:
                  this.finish();
          }
      }
      catch(Exception e){
          e.printStackTrace();
      }

    }
}
