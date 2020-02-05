package com.example.myapp.TeacherActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.myapp.R;

public class TeacherMainAct extends AppCompatActivity implements View.OnClickListener {

    Button btDziennik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);
        btDziennik = (Button) findViewById(R.id.btDziennik);
        btDziennik.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try{
            switch(v.getId()){
                case R.id.btDziennik:
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