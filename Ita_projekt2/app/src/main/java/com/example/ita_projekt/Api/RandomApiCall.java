package com.example.ita_projekt.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomApiCall {
    //www.themealdb.com/api/json/v1/1/random.php


    @GET("random.php")
    Call<RandomDataModel> getRandomDataModel();

    @GET("search.php?f=a")
    Call<RandomDataModel> getCategory();

    @GET("search.php?f=b")
    Call<RandomDataModel> getB();


}
