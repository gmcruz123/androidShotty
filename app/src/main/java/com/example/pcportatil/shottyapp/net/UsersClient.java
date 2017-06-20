package com.example.pcportatil.shottyapp.net;

import com.example.pcportatil.shottyapp.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by PC portatil on 15/06/2017.
 */

public interface UsersClient {
    @POST("users/signin")
    Call< RegisterResponse> register( @Body User user);

    @POST("users/login")
    Call<SimpleResponse> login( @Body User user);




}
