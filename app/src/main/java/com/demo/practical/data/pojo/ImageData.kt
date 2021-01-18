package com.demo.practical.data.pojo

data class ImageData(
        val `data`: Data,
        val message: Any,
        val status: Boolean
)

data class Data(
        val has_more: Boolean,
        val users: ArrayList<User>
)

data class User(
        val image: String,
        val items: ArrayList<String>,
        val name: String
)