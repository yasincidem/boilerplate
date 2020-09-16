package com.yasincidem.boilerplate.repository.impl

import com.yasincidem.boilerplate.core.base.repository.BaseRepositoryRemote
import com.yasincidem.boilerplate.core.util.ResultOf
import com.yasincidem.boilerplate.datasource.model.User
import com.yasincidem.boilerplate.datasource.remote.UserRemoteDataSource
import com.yasincidem.boilerplate.repository.HomeRepositoryContractor
import javax.inject.Inject

class HomeRepository @Inject constructor(
     remoteDataSource: UserRemoteDataSource
) : BaseRepositoryRemote<UserRemoteDataSource>(remoteDataSource), HomeRepositoryContractor {

    suspend fun fetchUser(): ResultOf<List<User>> {
        val user = remoteDataSource.fetchUser()
        return user
    }
}