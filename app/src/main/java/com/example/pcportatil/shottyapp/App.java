package com.example.pcportatil.shottyapp;
import android.app.Application;

import com.example.pcportatil.shottyapp.models.DaoMaster;
import com.example.pcportatil.shottyapp.models.DaoSession;
import com.google.gson.Gson;

import org.greenrobot.greendao.database.Database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC portatil on 17/06/2017.
 */

public class App extends Application {

  public  static DaoSession session;
  public static   Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://test-gina-shoty.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"reservas.db");
        Database db = helper.getWritableDb();
        session = new DaoMaster(db).newSession();

    }
}
