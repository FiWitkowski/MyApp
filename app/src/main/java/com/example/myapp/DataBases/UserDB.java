package com.example.myapp.DataBases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.Users.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class UserDB implements Serializable {
    private static UserDB ourInstance = new UserDB();

    private static LinkedList<User> lista = new LinkedList<>();
    public static UserDB getInstance() {
        return ourInstance;
    }

    public static boolean addUser(User u){
        return lista.add(u);
    }

    public static LinkedList<User> GetList(){
        return lista;
    }
    public static User searchUser(String userName){

        for (User user:lista
             ) {
            if(user.getUserName().equals(userName))
                return user;
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Boolean deleteUser(String userName){
        return lista.remove(searchUser(userName));
    }

    private UserDB() {
    }

    public void Serialize(){
        try{
            FileOutputStream fileOut =
                    new FileOutputStream("classes.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        }
        catch(Exception e){

        }
    }
    public void Deserialize(){
        try{
            FileInputStream fileIn = new FileInputStream("classes.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ourInstance = (UserDB) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(Exception e){

        }
    }
}
