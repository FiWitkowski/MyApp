package com.example.myapp.LayoutHandle.AdminPanelHandle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.DataBases.UserDB;
import com.example.myapp.R;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.UserLocalStore;

public class AddParent extends AppCompatActivity implements View.OnClickListener {
    Button btAddParent,btGoBack,btChooseChild;
    EditText etUserName, etPassword1,etPassword2,etFirstName,etLastName,etClass,etEmail,etPhone;
    UserLocalStore userLocalStore;
    UserDB userDB = UserDB.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parent);
        etUserName=findViewById(R.id.etUserNameAddParent);
        etPassword1=findViewById(R.id.etPassword1AddParent);
        etPassword2=findViewById(R.id.etPassword2AddParent);
        etFirstName=findViewById(R.id.etFirstNameAddParent);
        etLastName=findViewById(R.id.etLastNameAddParent);
        etEmail=findViewById(R.id.etEmailAddParent);
        btAddParent=findViewById(R.id.btAddParent2);
        btGoBack=findViewById(R.id.btGoBackAddParent);
        btChooseChild=findViewById(R.id.btChooseChildAddParent);
        userLocalStore=new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {
        try{
            switch (v.getId()){
                case R.id.btAddParent2:
                    //logic
                    if(etPassword1.getText()!=etPassword2.getText())
                        throw(new Exception("Passwords don't match"));
//                    userDB.addUser(new Parent(etFirstName.getText().toString(),
//                            etLastName.getText().toString(),
//                            etUserName.getText().toString(),
//                            etPassword1.getText().toString(),
//                            etPhone.getText().toString()));

                    break;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
