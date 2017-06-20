package com.example.pcportatil.shottyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pcportatil.shottyapp.databinding.ActivityLoginBinding;
import com.example.pcportatil.shottyapp.models.User;
import com.example.pcportatil.shottyapp.net.SimpleResponse;
import com.example.pcportatil.shottyapp.net.UsersClient;
import com.example.pcportatil.shottyapp.util.Preference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements Callback<SimpleResponse> {

    ActivityLoginBinding binding;
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


        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setHandler(this);

        client =( (App)getApplication()).retrofit.create(UsersClient.class);
    }

    public void goToMain(){

        String email = binding.email.getText().toString();
        String pass = binding.password.getText().toString();

        User user = new User(pass,email);


        Call<SimpleResponse> request = client.login(user);
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


    public void Register(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if (response.isSuccessful()){
            SimpleResponse simpleResponse = response.body();
            if (simpleResponse.isSuccess()){
                progressDialog.dismiss();
                String userId = simpleResponse.usersget().get_Id();
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(Preference.KEY_USERID,userId);
                editor.putBoolean(Preference.KEY_LOGGED,true);
                editor.apply();

                Log.d("userid",""+userId);

                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
            }else {
                progressDialog.dismiss();
                Toast.makeText(this, R.string.errorcontra,Toast.LENGTH_SHORT).show();
            }

        }

        else{
            Toast.makeText(this, R.string.falla,Toast.LENGTH_SHORT).show();

        }



    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {
        Toast.makeText(this,R.string.error_servidor_registro,Toast.LENGTH_SHORT);
    }
}
