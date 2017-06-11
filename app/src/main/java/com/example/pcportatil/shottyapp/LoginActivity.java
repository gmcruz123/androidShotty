package com.example.pcportatil.shottyapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pcportatil.shottyapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setHandler(this);

    }

    public void goToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }



}
