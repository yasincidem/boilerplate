package com.yasincidem.boilerplate.di

import com.yasincidem.boilerplate.api.service.ServiceManager
import com.yasincidem.boilerplate.api.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object ServicesModule {

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    @Singleton
    fun provideServiceManager(
        userService: UserService
    ): ServiceManager {
        return ServiceManager(
            userService
        )
    }
}