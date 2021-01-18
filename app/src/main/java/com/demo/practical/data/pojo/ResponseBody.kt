package com.demo.practical.data.pojo

import com.google.gson.annotations.SerializedName

data class ResponseBody<T>(@SerializedName("status") val status: Int,
                           @SerializedName("message") val message: String? = null,
                           @SerializedName("data") val data: T?) {

}