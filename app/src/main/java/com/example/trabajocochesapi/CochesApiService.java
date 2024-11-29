package com.example.trabajocochesapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CochesApiService {
    @GET("Coches")
    Call<List<CochesResponse>> getCochesList(@Query("apikey") String apikey);
}
