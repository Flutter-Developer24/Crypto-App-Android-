package com.example.crypto.Apis;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiServices {


    @GET("24hr")
    Call<List<Result>> getlist();
}
