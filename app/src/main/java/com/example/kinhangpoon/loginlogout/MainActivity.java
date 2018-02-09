package com.example.kinhangpoon.loginlogout;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MyInterface{
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("myfile", Context.MODE_PRIVATE);
        if(sharedPreferences.getString("username","").equals("")||sharedPreferences.getString("password","").equals("")){
            getSupportFragmentManager().beginTransaction().replace(R.id.main,new LogInFragment()).addToBackStack(null).commit();
        }
        else{
            getSupportFragmentManager().beginTransaction().replace(R.id.main,new LogOutFragment()).addToBackStack(null).commit();
        }
    }

    @Override
    public void replace(View v) {
        switch (v.getId()){
            case R.layout.login_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.main,new LogOutFragment()).commit();
            case R.layout.logout_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.main,new LogInFragment()).commit();

        }
    }
}
