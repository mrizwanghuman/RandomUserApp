package com.example.admin.randomuserapp;

import com.example.admin.randomuserapp.modal.RandomResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by  Admin on 11/20/2017.
 */

public interface RandomMeService {
    @GET("api/?results=10")
    Call<RandomResponse> getRandomUser();
}
