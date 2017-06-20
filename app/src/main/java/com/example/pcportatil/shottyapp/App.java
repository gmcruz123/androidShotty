package com.example.pcportatil.shottyapp;
import android.app.Application;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC portatil on 17/06/2017.
 */

public class App extends Application {

  public static   Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://test-gina-shoty.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
}
