package com.example.myapp.LayoutHandle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.myapp.Misc.Subject;
import com.example.myapp.R;
import com.example.myapp.Users.Parent;
import com.example.myapp.Users.Student;

import java.util.Collections;
import java.util.List;

public class ParentActivity extends AppCompatActivity {
    Button bt_SelectChild,bt_SelectSubject, bt_Clear;
    ListView lv_ChildList, lv_SubjectList,lv_GradeList;
    Parent parent;
    ArrayAdapter<Integer> adapterGrades;
    List<Integer> gradeList;
    ArrayAdapter<Subject> adapterSubjects;
    List<Subject> subjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        //w aktywnosci gdy logujemy sie jako rodzic
        //Parent parent = new Parent(bla bla bla);
        //Intent i = new Intent(this, ParentActivity.class);
        //i.putExtra("parent", parent);
        //startActivity(i);
        bt_SelectChild=findViewById(R.id.bt_SelectChildParentActivity);
        bt_SelectSubject=findViewById(R.id.bt_SelectSubjectParentActivity);
        bt_Clear=findViewById(R.id.bt_ClearParentActivity);
        Intent i = getIntent();
        parent = (Parent)i.getSerializableExtra("parent");
        List<Student> children=parent.childList;
        lv_ChildList=findViewById(R.id.lv_ChildListParentActivity);
        final ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this,
                android.R.layout.simple_list_item_1, parent.childList);

        lv_ChildList.setAdapter(adapter);

    }

    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.bt_SelectChildParentActivity:
                    if(lv_ChildList.getSelectedItem()!=null) {
                        final Student student = (Student) lv_ChildList.getSelectedItem();
                        for (Subject s: student.grades.keySet()) {
                            subjectList.add(s);
                        }
                        adapterSubjects=new ArrayAdapter<Subject>(this,
                                android.R.layout.simple_list_item_1, subjectList);
                         lv_SubjectList.setAdapter(adapterSubjects);
                    }
                    else throw(new Exception("Select child!"));

                    break;
                case R.id.bt_SelectSubjectParentActivity:
                    if(lv_ChildList.getSelectedItem()==null || lv_SubjectList.getSelectedItem()==null) throw(new Exception("Select child or subject!"));
                    gradeList= parent.checkGrades((Student) lv_ChildList.getSelectedItem(),(Subject) lv_SubjectList.getSelectedItem());
                    adapterGrades = new ArrayAdapter<Integer>(this,
                            android.R.layout.simple_list_item_1, gradeList);
                    lv_GradeList.setAdapter(adapterGrades);
                    break;

                case R.id.bt_ClearParentActivity:
                    gradeList.clear();
                    adapterGrades.notifyDataSetChanged();
                    subjectList.clear();
                    adapterSubjects.notifyDataSetChanged();
                    break;

                case R.id.bt_ExitParentActivity:
                    this.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
