package com.example.myapp.DataBases;

import java.io.Serializable;

public class ClassDB implements Serializable {
    private static final ClassDB ourInstance = new ClassDB();

    public static ClassDB getInstance() {
        return ourInstance;
    }

    private ClassDB() {
    }
}
