package com.example.newsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    public static Retrofit retrofit=null;

    public static Api_interface getApi_interface(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(Api_interface.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api_interface.class);
    }
}


