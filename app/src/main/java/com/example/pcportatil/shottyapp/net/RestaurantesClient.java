package com.example.pcportatil.shottyapp.net;

import com.example.pcportatil.shottyapp.models.Like;
import com.example.pcportatil.shottyapp.models.PromoEvento;
import com.example.pcportatil.shottyapp.models.Reserva;
import com.example.pcportatil.shottyapp.models.Restaurante;
import com.example.pcportatil.shottyapp.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by PC portatil on 17/06/2017.
 */

public interface RestaurantesClient {


    //region Likes
    @PUT("restaurantes/{nombre}")
    Call<SimpleResponse> Reslikes(@Path("nombre") String nombre , @Body Like like);

    @PUT("discotecas/{nombre}")
    Call<SimpleResponse> Dislikes(@Path("nombre") String nombre , @Body Like like);
    //endregion

    //region Listar
    @GET("discotecas")
    Call<List<Restaurante>> allDis();

    @GET("restaurantes")
    Call<List<Restaurante>> allRes();

    @GET("reservasiones") //concatenar el id del usuario
    Call<List<Reserva>> allReservas();

    @GET("promociones") //concatenar el id del usuario
    Call<List<PromoEvento>> allPromo();

    @GET("eventos") //concatenar el id del usuario
    Call<List<PromoEvento>> allEventos();
    //endregion
}
