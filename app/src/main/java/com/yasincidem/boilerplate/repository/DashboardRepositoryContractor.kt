package com.yasincidem.boilerplate.repository

import com.yasincidem.boilerplate.core.util.ResultOf
import com.yasincidem.boilerplate.datasource.model.User

interface DashboardRepositoryContractor {
    suspend fun fetchUser() : ResultOf<List<User>>
}