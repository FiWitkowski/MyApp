package com.example.myapp.LayoutHandle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapp.DataBases.UserDB;
import com.example.myapp.Misc.Subject;
import com.example.myapp.R;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ParentActivity extends AppCompatActivity {
    Button bt_CheckGrades;
    ListView lv_SubjectList,lv_GradeList;
    Parent parent;
    ArrayAdapter<Integer> adapterGrades;
    List<Integer> gradeList;
    ArrayAdapter<Subject> adapterSubjects;
    List<Subject> subjectList;

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        //w aktywnosci gdy logujemy sie jako rodzic
        //Parent parent = new Parent(bla bla bla);
        //Intent i = new Intent(this, ParentActivity.class);
        //i.putExtra("parent", parent);
        //startActivity(i);

        bt_CheckGrades=findViewById(R.id.bt_CheckGradesParentActivity);
        Intent i = getIntent();
        parent = (Parent)i.getSerializableExtra("parent");
        for(Subject s:((Student)UserDB.getInstance().searchUser(parent.child.userName)).grades.keySet()){
            subjectList.add(s);
        }
        adapterSubjects= new ArrayAdapter<Subject>(this, android.R.layout.simple_list_item_1, subjectList);
        lv_SubjectList.setAdapter(adapterGrades);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.bt_CheckGradesParentActivity:
                    if (lv_SubjectList.getSelectedItem() != null){
                        Subject subject = (Subject) lv_SubjectList.getSelectedItem();
                        gradeList = parent.checkGrades(subject);
                        adapterGrades = new ArrayAdapter<Integer>(this,
                            android.R.layout.simple_list_item_1, gradeList);
                        lv_GradeList.setAdapter(adapterGrades);
                    }
                    break;
                case R.id.bt_ExitParentActivity:
                this.finish();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
