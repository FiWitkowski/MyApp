package com.example.myapp.LayoutHandle.AdminPanelHandle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.DataBases.UserDB;
import com.example.myapp.R;

public class AddTeacher extends AppCompatActivity implements View.OnClickListener{
    Button btAddTeacher2,btGoBackAddTeacher;
    EditText etUserName, etPassword1,etPassword2,etFirstName,etLastName,etEmail,etDay,etMonth,etYear;

    UserLocalStore userLocalStore;
    UserDB userDB = UserDB.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
        etUserName=findViewById(R.id.etUserNameAddTeacher);
        etPassword1=findViewById(R.id.etPassword1AddTeacher);
        etPassword2=findViewById(R.id.etPassword2AddTeacher);
        etEmail=findViewById(R.id.etEmailAddTeacher);
        etFirstName=findViewById(R.id.etFirstNameAddTeacher);
        etLastName=findViewById(R.id.etLastNameAddTeacher);
        etDay=findViewById(R.id.etDayAddTeacher);
        etMonth=findViewById(R.id.etMonthAddTeacher);
        etYear=findViewById(R.id.etYearAddTeacher);
        btAddTeacher2=findViewById(R.id.btAddTeacher2);
        btGoBackAddTeacher=findViewById(R.id.btGoBackAddTeacher);
        userLocalStore=new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.btAddTeacher2:
                    //logic
                    if (etPassword1.getText() != etPassword2.getText())
                        throw (new Exception("Passwords don't match"));
//                    userDB.addUser(new Teacher(etFirstName.getText().toString(),
//                            etLastName.getText().toString(),
//                            etUserName.getText().toString(),
//                            etPassword1.getText().toString()));

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
