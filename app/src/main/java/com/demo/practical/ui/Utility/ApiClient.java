package com.demo.practical.ui.Utility;

import androidx.annotation.NonNull;

import com.demo.practical.data.pojo.Data;
import com.demo.practical.data.pojo.ImageData;
import com.demo.practical.data.service.UserService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import io.reactivex.Observable;
import retrofit.RxJavaCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private String BASE_URL = "http://sd2-hiring.herokuapp.com/api/";
    private static ApiClient instance;
    private UserService apiqueryinterface;

    private ApiClient() {
        final Gson gson =
                new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiqueryinterface = retrofit.create(UserService.class);
    }

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public Observable<ImageData> getUsers(@NonNull int key, @NonNull int address) {
        return apiqueryinterface.getImages1(key, address);
    }
}