package com.example.myapp.TeacherActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myapp.DataBases.UserDB;
import com.example.myapp.Misc.Subject;
import com.example.myapp.R;
import com.example.myapp.Users.AccessLevel;
import com.example.myapp.Users.CurrentUser;
import com.example.myapp.Users.Student;
import com.example.myapp.Users.Teacher;
import com.example.myapp.Users.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EditMark extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mark);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.6));

    }

    public static class StudentListFinale extends AppCompatActivity {

        private ListView list ;
        Button btAddGrade;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_list_finale);
            list = (ListView) findViewById(R.id.ListViewStudents);

            Intent intent = getIntent();

            //final Class schoolClass = ((Teacher) CurrentUser.getUser()).subject;
            final List<Subject> subjects = ((Teacher) CurrentUser.getUser()).subjects;
            String[] from = new String[]{"rowid", "col_1", "col_2"};
            int[] to = new int[]{R.id.col1, R.id.col2, R.id.col3};
            List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
            List<Student> students = new ArrayList<>();
            //MainController.getInstance().getListOfStudents(schoolClass);
            if(subjects.size()>0)
                for (Subject subject:subjects
                ) {
                    for (User user: UserDB.GetList()
                         ) {
                        if(user.typeOfUser.equals(AccessLevel.STUDENT)){
                          if(((Student)user).grades.containsKey(subject))
                              students.add((Student)user);
                        }
                    }


                }

            for (int i = 0; i < students.size(); i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("rowid", "" + (i + 1));
                map.put("col_1", students.get(i).getLastName());
                map.put("col_2", students.get(i).getFirstName());
                fillMaps.add(map);
            }
            SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, android.R.layout.simple_list_item_1,from, to);
            list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapter, View v, int position, long l){
                    Student itempupil = (Student) adapter.getItemAtPosition(position);
                    final Bundle bundle = new Bundle();
    //                bundle.putSerializable("CHILD", (Serializable) students.get(position));
    //                bundle.putSerializable("SUBJECT",subject);
    //                bundle.putSerializable("SCHOOL_CLASS", schoolClass);
                    bundle.putString("STUDENT",itempupil.userName);

                    Intent intent = new Intent(StudentListFinale.this, GradeList.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }



    }
}