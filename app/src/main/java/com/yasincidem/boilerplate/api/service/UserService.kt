package com.yasincidem.boilerplate.api.service

import com.yasincidem.boilerplate.datasource.model.User
import retrofit2.Response
import retrofit2.http.GET


interface UserService {

    @GET("/api/dashboard/dashboard")
    suspend fun fetchUser(): Response<List<User>>

}