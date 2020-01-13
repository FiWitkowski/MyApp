package com.example.myapp;

import com.example.myapp.Users.User;

public interface GetUserCallback {
    public abstract void done(User returnedUser);
}
