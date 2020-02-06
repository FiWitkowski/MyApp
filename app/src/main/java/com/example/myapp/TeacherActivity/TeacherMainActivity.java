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
        btDziennik = findViewById(R.id.btStudents);
        btDziennik.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try{
            switch(v.getId()){
                case R.id.btStudents:
                    startActivity(new Intent(this, EditMark.StudentListFinale.class));
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
