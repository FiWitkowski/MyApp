package com.example.myapp.DataBases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.Users.User;

import java.io.Serializable;
import java.util.LinkedList;

public class UserDB implements Serializable {
    private static final UserDB ourInstance = new UserDB();

    private LinkedList<User> lista = new LinkedList<>();
    public static UserDB getInstance() {
        return ourInstance;
    }

    public boolean addUser(User u){
        return lista.add(u);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public User searchUser(String userName){

    return lista.stream().filter(user -> user.getUserName().equals(userName)).findAny().orElse(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Boolean deleteUser(String userName){
        return lista.remove(searchUser(userName));
    }

    private UserDB() {
    }
}
