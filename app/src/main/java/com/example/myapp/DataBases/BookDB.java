package com.example.myapp.DataBases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapp.Misc.Book;
import com.example.myapp.Users.User;

import java.io.Serializable;
import java.util.LinkedList;

public class BookDB implements Serializable {
    private static BookDB ourInstance = new BookDB();

    private static LinkedList<Book> lista = new LinkedList<>();
    public static BookDB getInstance() {
        return ourInstance;
    }

    public static boolean addUser(Book b){
        return lista.add(b);

    }


    public static Book searchBook(String bookName){

        for (Book book:lista
        ) {
            if(book.tytul.equals(bookName))
                return book;
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Boolean deleteBook(String bookName){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).tytul.equals(bookName)){
                lista.remove(i);
                return true;
            }
        }
        return false;
    }

    private BookDB() {
    }
}
