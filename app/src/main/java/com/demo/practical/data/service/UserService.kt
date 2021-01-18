package com.demo.practical.data.service

import com.demo.practical.data.URLFactory
import com.demo.practical.data.pojo.Data
import com.demo.practical.data.pojo.ImageData
import com.demo.practical.data.pojo.ResponseBody
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    //    @GET(URLFactory.Method.GET_IMAGES)
    @GET("users?offset=10&limit=10")
    fun getImages(): Single<ResponseBody<Data>>

    //    fun getImages(@Query("offset") offset: Int, @Query("limit") limit: Int): Single<ResponseBody<Data>>
//
    @GET(URLFactory.Method.GET_IMAGES)
    fun getImages1(@Query("offset") offset: Int, @Query("limit") limit: Int): Observable<ImageData>

//    @GET("users")
//    fun getUsers(
//            @Query("key") String key,
//            @Query("address") String address
//    ): Observable<<List<Users>>

}