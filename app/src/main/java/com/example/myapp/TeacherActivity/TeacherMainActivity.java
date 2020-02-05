package com.example.myapp.TeacherActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapp.R;

public class TeacherMainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btDziennik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachermainactivity);
        btDziennik = (Button) findViewById(R.id.btStudentsList);
        btDziennik.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try{
            switch(v.getId()){
                case R.id.btStudentsList:
                    startActivity(new Intent(this,StudentList.class));
                    break;
                default:
                    break;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
