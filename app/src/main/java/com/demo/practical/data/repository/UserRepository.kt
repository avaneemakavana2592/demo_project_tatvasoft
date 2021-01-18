package com.demo.practical.data.repository

import com.demo.practical.data.pojo.Data
import com.demo.practical.data.pojo.DataWrapper
import com.demo.practical.data.pojo.User
import io.reactivex.Single

interface UserRepository {

    fun getImages(): Single<DataWrapper<Data>>
}