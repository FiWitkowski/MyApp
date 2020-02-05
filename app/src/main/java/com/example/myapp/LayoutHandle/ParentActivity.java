package com.example.myapp.LayoutHandle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.myapp.DataBases.UserDB;
import com.example.myapp.Misc.Subject;
import com.example.myapp.R;
import com.example.myapp.Users.CurrentUser;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ParentActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    Button bt_CheckGrades,bt_Exit;
    ListView lv_GradeList;
    Parent parent;
    Spinner spinnerSubject;
    ArrayAdapter<String> adapterGrades;
    ArrayList<Integer> gradeList=new ArrayList<>();
    ArrayAdapter<String> adapterSubjects;
    ArrayList<String> subjectList=new ArrayList<>();


    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);


        bt_CheckGrades=findViewById(R.id.bt_CheckGradesParentActivity);
        bt_Exit=findViewById(R.id.bt_ExitParentActivity);
        spinnerSubject=findViewById(R.id.spinnerSubjectParentActivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bt_CheckGrades.setOnClickListener(this);
        bt_Exit.setOnClickListener(this);
        spinnerSubject.setOnItemSelectedListener(this);
        Intent i = getIntent();
        parent = (Parent) CurrentUser.getUser();
        lv_GradeList=(ListView) findViewById(R.id.lv_GradeListParentActivity);

        if(parent.child!=null) {

            for (Subject s : parent.child.grades.keySet()) {
                subjectList.add(s.toString());

            }
        }
        adapterSubjects = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, subjectList);
        adapterSubjects.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(adapterSubjects);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {

        try {
            switch (v.getId()) {
                case R.id.bt_CheckGradesParentActivity:
                    String subject = (String) spinnerSubject.getSelectedItem().toString();
                    gradeList = parent.checkGrades(subject);
                    ArrayList<String> lista=new ArrayList<>();
                    for (Integer integer : gradeList) {
                        lista.add(integer.toString());
                    }

                    lv_GradeList=findViewById(R.id.lv_GradeListParentActivity);
                    adapterGrades = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
                    lv_GradeList.setAdapter(adapterGrades);
                    lv_GradeList.setVisibility(View.VISIBLE);

                    break;

                case R.id.bt_ExitParentActivity:
                finish();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerSubject.setSelection(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        spinnerSubject.setSelection(0);
    }

}
