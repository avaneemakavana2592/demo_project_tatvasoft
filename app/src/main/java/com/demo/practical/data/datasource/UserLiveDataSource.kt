package com.demo.practical.data.datasource

import com.demo.practical.data.pojo.Data
import com.demo.practical.data.pojo.DataWrapper
import com.demo.practical.data.repository.UserRepository
import com.demo.practical.data.service.UserService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLiveDataSource @Inject constructor(private val userService: UserService) : BaseDataSource(), UserRepository {

    override fun getImages(): Single<DataWrapper<Data>> {
        return execute(userService.getImages())
    }
}
