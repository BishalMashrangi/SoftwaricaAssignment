package com.e.softwaricaassignment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Fragments.LoginActivity;
import Fragments.RegistrationActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnLoad;
    private Boolean status=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoad =findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

        if(status){
            LoginActivity loginActivity= new LoginActivity();
            fragmentTransaction.replace(R.id.fragmentContainer,loginActivity);
            fragmentTransaction.commit();
            btnLoad.setText("Login");
            status=false;
        }else {
            RegistrationActivity registrationActivity= new RegistrationActivity();
            fragmentTransaction.replace(R.id.fragmentContainer, registrationActivity);
            fragmentTransaction.commit();
            btnLoad.setText("Registered");
            status= true;
        }

    }
}

