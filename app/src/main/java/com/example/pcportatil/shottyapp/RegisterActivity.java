package com.example.pcportatil.shottyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pcportatil.shottyapp.databinding.ActivityRegisterBinding;
import com.example.pcportatil.shottyapp.models.User;
import com.example.pcportatil.shottyapp.net.RegisterResponse;
import com.example.pcportatil.shottyapp.net.SimpleResponse;
import com.example.pcportatil.shottyapp.net.UsersClient;
import com.example.pcportatil.shottyapp.util.Preference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements Callback<RegisterResponse> {

    ActivityRegisterBinding binding;
    UsersClient client;
    SharedPreferences preferences;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(Preference.PREFERENCE_NAME,MODE_PRIVATE);
        boolean logged = preferences.getBoolean(Preference.KEY_LOGGED,false);
        if (logged){

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return;

        }

        setContentView(R.layout.activity_register);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        binding.setHandler(this);
        client =( (App)getApplication()).retrofit.create(UsersClient.class);


    }

    public  void Register(){

        Log.d("bla","asd");

        String username= binding.email.getText().toString();
        String password = binding.password.getText().toString();
        String email = binding.email1.getText().toString();

        if (username.equals("")|| password.equals("")||email.equals("")){

            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();


        }


        else {
            Log.i("hola","babab");



            User user = new User(username,password,email);
            Call<RegisterResponse> request = client.register(user);
            request.enqueue(this);

            progressDialog = new ProgressDialog(this);
            progressDialog.show();
            progressDialog.setContentView(R.layout.activity_progress);

            final int totalProgressTime = 100;
            final Thread t = new Thread() {
                @Override
                public void run() {
                    int jumpTime = 0;

                    while(jumpTime < totalProgressTime) {
                        try {
                            sleep(200);
                            jumpTime += 5;
                            progressDialog.setProgress(jumpTime);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            };t.start();




        }



    }


    @Override
    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
        if(response.isSuccessful()){
            RegisterResponse registerResponse = response.body();

            if(registerResponse.isSuccess()){
                progressDialog.dismiss();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();

            }else if(registerResponse.isExist()){
                progressDialog.dismiss();
                Toast.makeText(this, R.string.registro_existente, Toast.LENGTH_SHORT).show();
            }

        }

        else {
            progressDialog.dismiss();
            Toast.makeText(this,R.string.error_servidor_registro,Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onFailure(Call<RegisterResponse> call, Throwable t) {
        Toast.makeText(this, R.string.error_servidor_registro, Toast.LENGTH_SHORT).show();
    }
}
