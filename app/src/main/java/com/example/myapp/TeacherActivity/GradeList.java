package com.example.myapp.TeacherActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;

import com.example.myapp.LayoutHandle.MainController;
import com.example.myapp.Misc.Grade;
import com.example.myapp.Misc.Subject;
import com.example.myapp.Misc.Class;
import com.example.myapp.R;
import com.example.myapp.Users.Student;

import java.util.ArrayList;
import java.util.Date;

public class GradeList extends AppCompatActivity implements View.OnClickListener{

    private ListView list ;
    private ArrayAdapter<Grade> adapter ;
    private MainController controller=MainController.getInstance();


    private Context mContext;
    private Activity mActivity;
    private ConstraintLayout mConstraintLayout;
    //private PopupWindow mPopupWindow;
    private Button addButton;
    String[] grades = {"1","2","3","4","5","6"};
    String[] types = {"Kartkówka","Sprawdzian","Odpowiedź","Zadanie"};
    Class sc;
    Subject subject;
    Student pupil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_list);
        mContext = getApplicationContext();
        mActivity = GradeList.this;
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.cl);
        list = (ListView) findViewById(R.id.listView1);
        addButton = (Button) findViewById(R.id.btAddGrade);
        Intent intent = getIntent();
        final Bundle childbundle = intent.getExtras();


        pupil = (Student) childbundle.getSerializable("CHILD");
        subject = (Subject) childbundle.getSerializable("SUBJECT");
        sc = (Class) childbundle.getSerializable("SCHOOL_CLASS");


        final ArrayList<Grade> oldGrades = controller.getListOfGrades(pupil,subject);
        adapter = new ArrayAdapter<Grade>(this, android.R.layout.simple_list_item_1, oldGrades);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long l){
                final Grade oldGrade=(Grade) oldGrades.get(position);
                LayoutInflater layoutInflater =
                        (LayoutInflater)getBaseContext()
                                .getSystemService(LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.activity_edit_mark, null);
                final PopupWindow popupWindow = new PopupWindow(
                        customView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                final Spinner popupSpinner1 = (Spinner)customView.findViewById(R.id.marksSpinner1);
                final Spinner popupSpinner2 = (Spinner)customView.findViewById(R.id.typeSpinner);
                ArrayAdapter<String> a =
                        new ArrayAdapter<String>(GradeList.this,
                                android.R.layout.simple_spinner_item, grades);
                a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                popupSpinner1.setAdapter(a);
                ArrayAdapter<String> b =
                        new ArrayAdapter<String>(GradeList.this,
                                android.R.layout.simple_spinner_item, types);
                b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                popupSpinner2.setAdapter(b);
                Button changeButton = (Button) customView.findViewById(R.id.changeButton);
                Button cancelButton = (Button) customView.findViewById(R.id.cancelButton);
                Button deleteButton = (Button) customView.findViewById(R.id.deleteButton);
                ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
                changeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String grade=(String) popupSpinner1.getSelectedItem().toString();
                        String type=popupSpinner2.getSelectedItem().toString();
                        Grade newGrade=new Grade(pupil,Integer.parseInt(grade),subject, sc, oldGrade.getDate());
                        controller.updateGrade(oldGrade,newGrade);
                        popupWindow.dismiss();
                        finish();
                        startActivity(getIntent());
                    }
                });
                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        controller.deleteGrade(oldGrade);
                        popupWindow.dismiss();
                        finish();
                        startActivity(getIntent());
                    }
                });
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAtLocation(mConstraintLayout, Gravity.CENTER,0,0);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater =
                        (LayoutInflater)getBaseContext()
                                .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.activity_add_mark, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


                final Spinner popupSpinner1 = (Spinner)popupView.findViewById(R.id.marksSpinner1);
                final Spinner popupSpinner2 = (Spinner)popupView.findViewById(R.id.typeSpinner);

                ArrayAdapter<String> a =
                        new ArrayAdapter<String>(GradeList.this,
                                android.R.layout.simple_spinner_item, grades);
                a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                popupSpinner1.setAdapter(a);

                ArrayAdapter<String> b =
                        new ArrayAdapter<String>(GradeList.this,
                                android.R.layout.simple_spinner_item, types);
                b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                popupSpinner2.setAdapter(b);

                Button cancelButton = (Button) popupView.findViewById(R.id.cancelButton);
                Button addButton = (Button) popupView.findViewById(R.id.btAddGrade);
                ImageButton closeButton = (ImageButton) popupView.findViewById(R.id.ib_close);

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String grade=popupSpinner1.getSelectedItem().toString();
                        Grade newGrade=new Grade(pupil,Integer.parseInt(grade),subject);
                        controller.addGrade(newGrade);
                        finish();
                        startActivity(getIntent());
                        popupWindow.dismiss();
                    }
                });

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });



                popupWindow.showAtLocation(mConstraintLayout, Gravity.CENTER,0,0);
            }

        });
    }

    @Override
    public void onClick(View v) {

    }
}