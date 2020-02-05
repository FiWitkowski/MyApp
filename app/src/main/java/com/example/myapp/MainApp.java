package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapp.LayoutHandle.Login;
import com.example.myapp.LayoutHandle.MainController;
import com.example.myapp.LayoutHandle.Settings;
import com.example.myapp.Users.User;
import com.example.myapp.Users.UserLocalStore;


public class MainApp extends AppCompatActivity implements View.OnClickListener {

    MainController m = new MainController();

    Button buttonLogout,buttonSettings;
    UserLocalStore userLocalStore;
    Button tvUserDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        //need to change
        tvUserDetails = (Button) findViewById(R.id.buttonLogout);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonSettings = (Button) findViewById(R.id.buttonSettings);
        buttonLogout.setOnClickListener(this);
        buttonSettings.setOnClickListener(this);
    //    userLocalStore = new UserLocalStore(this);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(authenticate()){
//        displayUserDetails();
//        }else{
//            startActivity(new Intent(this,Login.class));
//        }
//    }

    public void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();
    tvUserDetails.setText(user.firstName+" "+user.lastName);
    }

    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogout:
                //userLocalStore.clearuserData();
                //userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.buttonSettings:
                startActivity(new Intent(this, Settings.class));
                break;
        }
    }
}
