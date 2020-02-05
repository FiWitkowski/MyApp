package com.example.myapp.Misc;

public class Book {
    public String tytul;
    public int iloscDostepnych;

    public Book(String tytul, int ilosc){
        this.tytul=tytul;
        this.iloscDostepnych=ilosc;
    }
    public Book Rent(){
        if(iloscDostepnych>0){
            iloscDostepnych--;
            return this;
        }
        return null;
    }
}
