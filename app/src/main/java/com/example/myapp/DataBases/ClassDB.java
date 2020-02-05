package com.example.myapp.DataBases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.Misc.Class;

import java.io.Serializable;
import java.util.LinkedList;

public class ClassDB implements Serializable {
    private static ClassDB ourInstance = new ClassDB();

    public static ClassDB getInstance() {
        return ourInstance;
    }


    protected static LinkedList<Class> classes=new LinkedList<Class>();


    private ClassDB() {
    }

    public static Class addClass(Class c){
        classes.add(c);
        return c;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Class searchClass(String className){
        for (Class c: classes) {
            if(c.getClassName().equals(className)) return c;
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Boolean deleteClass(String className){
        return classes.remove(searchClass(className));
    }
}
