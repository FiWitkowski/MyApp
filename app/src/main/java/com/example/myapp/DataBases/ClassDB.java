package com.example.myapp.DataBases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.Misc.Class;
import com.example.myapp.Users.User;

import java.io.Serializable;
import java.util.LinkedList;

public class ClassDB implements Serializable {
    private static final ClassDB ourInstance = new ClassDB();

    public static ClassDB getInstance() {
        return ourInstance;
    }

    protected LinkedList<Class> classes;
    private ClassDB() {
    }

    public boolean addUser(Class c){
        return classes.add(c);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public Class searchClass(String className){

        return classes.stream().filter(myclass -> myclass.getClassName().equals(className)).findAny().orElse(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Boolean deleteClass(String className){
        return classes.remove(searchClass(className));
    }
}
