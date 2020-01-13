package com.example.myapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.myapp.Users.User;

import org.apache.http.params.HttpParams;

import java.util.HashMap;
import java.util.Map;


public class ServerRequests {

    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT =1000*15;
    public static final String SERVER_ADDRESS = "http://zsiproject.000webhostapp.com/";

    public ServerRequests(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }

    public void storeUserDataInBackground(User user, GetUserCallback callback){
        progressDialog.show();
        new StoreUserDataAsyncTask(user,callback).execute();
    }

    public void fetchUserDataInBackground(User user, GetUserCallback callback){
        progressDialog.show();
    }
    public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void>{
        User user;
        GetUserCallback userCallback;

        public StoreUserDataAsyncTask(User user, GetUserCallback callback){
            this.user=user;
            this.userCallback=callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Map<String,String> dataToSend=new HashMap<>();
            dataToSend.put("userName",user.getUserName());
            dataToSend.put("password",user.getPassword());
            dataToSend.put("firstName",user.firstName);
            dataToSend.put("lastName",user.lastName);
            dataToSend.put("age", user.age+"");
            dataToSend.put("dateOfBirth",user.dateOfBirth.toString());
            dataToSend.put("typeOfUser",user.typeOfUser.toString());
            dataToSend.put("emailAddress",user.emailAddress.toString());

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();
            userCallback.done(null);
            super.onPostExecute(aVoid);
        }
    }
}
