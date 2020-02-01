package com.example.myapp.LayoutHandle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapp.LayoutHandle.AdminPanelHandle.AddParent;
import com.example.myapp.LayoutHandle.AdminPanelHandle.AddStudent;
import com.example.myapp.LayoutHandle.AdminPanelHandle.AddTeacher;
import com.example.myapp.R;

public class AdminPanel extends AppCompatActivity implements View.OnClickListener {

    Button btAddStudent,btAddParent,btAddTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        btAddStudent=findViewById(R.id.btAddStudent);
        btAddStudent.setOnClickListener(this);
        btAddParent=findViewById(R.id.btAddParent);
        btAddParent.setOnClickListener(this);
        btAddTeacher=findViewById(R.id.btAddTeacher);
        btAddTeacher.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try{
            switch (v.getId()){
                case R.id.btAddStudent:
                    startActivity(new Intent(this, AddStudent.class));
                    break;
                case R.id.btAddParent:
                    startActivity(new Intent(this, AddParent.class));
                    break;
                case R.id.btAddTeacher:
                    startActivity(new Intent(this, AddTeacher.class));

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
