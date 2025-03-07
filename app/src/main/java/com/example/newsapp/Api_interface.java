package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_interface {

    String BASE_URL="https://newsapi.org/v2/";

   @GET("Top-headlines")
    Call<mainNewsModal> getnews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey")String apikey
    );

    @GET("Top-headlines")
    Call<mainNewsModal> getcategorynews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("category") String category,
            @Query("apiKey")String apikey
    );
}

