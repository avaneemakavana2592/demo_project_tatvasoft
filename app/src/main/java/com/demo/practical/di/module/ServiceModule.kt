package com.demo.practical.di.module

import com.demo.practical.data.datasource.UserLiveDataSource
import com.demo.practical.data.repository.UserRepository
import com.demo.practical.data.service.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideUserRepository(userLiveDataSource: UserLiveDataSource): UserRepository {
        return userLiveDataSource
    }

    @Provides
    @Singleton
    fun provideAuthenticationService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

}