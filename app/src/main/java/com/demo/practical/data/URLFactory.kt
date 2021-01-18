package com.demo.practical.data


import okhttp3.HttpUrl

/**
 * Created by hlink21 on 11/5/17.
 */

object URLFactory {

    // server details
    private const val SCHEME = "http"
    private val HOST = "sd2-hiring.herokuapp.com"
    private val API_PATH = "api/"

    fun provideHttpUrl(): HttpUrl {
        return HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegments(API_PATH)
                .build()
    }


    // API Methods
    object Method {
        const val GET_IMAGES = "users"
    }

}
