package com.yasincidem.boilerplate.datasource.remote

import com.yasincidem.boilerplate.api.service.ServiceManager
import com.yasincidem.boilerplate.core.base.repository.IRemoteDataSource
import com.yasincidem.boilerplate.core.ext.processResponse
import com.yasincidem.boilerplate.core.util.ResultOf
import com.yasincidem.boilerplate.datasource.model.User
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val serviceManager: ServiceManager
) : IRemoteDataSource {

    suspend fun fetchUser(): ResultOf<List<User>> {
        return processResponse { serviceManager.userService.fetchUser() }
    }
}