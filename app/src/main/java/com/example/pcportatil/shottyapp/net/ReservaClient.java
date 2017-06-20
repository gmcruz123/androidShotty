package com.example.pcportatil.shottyapp.net;

import android.content.SharedPreferences;

import com.example.pcportatil.shottyapp.models.Reserva;
import com.example.pcportatil.shottyapp.models.Restaurante;
import com.example.pcportatil.shottyapp.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by PC portatil on 19/06/2017.
 */

public interface ReservaClient {

    @POST("reservaciones")
    Call<SimpleResponse> reservacion(@Body Reserva reserva);

    @GET("reservaciones/{id}")
    Call<List<Reserva>> allReservas(@Path("id") String idusu);

}
