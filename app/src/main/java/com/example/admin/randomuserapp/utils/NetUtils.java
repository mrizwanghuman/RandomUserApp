package com.example.admin.randomuserapp.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.admin.randomuserapp.utils.Constrants.BASE_URL;

/**
 * Created by  Admin on 11/20/2017.
 */

public class NetUtils {
    private static OkHttpClient httpClientConfig(HttpLoggingInterceptor interceptor){
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();



    }
    private static HttpLoggingInterceptor loggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  httpLoggingInterceptor;
    }

    public static Retrofit retrofitConfig(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL).client(httpClientConfig(loggingInterceptor()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
