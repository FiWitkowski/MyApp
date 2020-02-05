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

    protected static LinkedList<Class> classes;
    private ClassDB() {
    }

    public static Class addClass(Class c){
        classes.add(c);
        return c;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Class searchClass(String className){

        return classes.stream().filter(myclass -> myclass.getClassName().equals(className)).findAny().orElse(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Boolean deleteClass(String className){
        return classes.remove(searchClass(className));
    }
}
