package com.yasincidem.boilerplate.ui.main.dashboard

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.yasincidem.boilerplate.core.util.ResultOf
import com.yasincidem.boilerplate.datasource.model.User
import com.yasincidem.boilerplate.repository.impl.DashboardRepository

class DashboardViewModel @ViewModelInject constructor(
    private val repository: DashboardRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val user: LiveData<ResultOf<List<User>>> = liveData {
        emit(repository.fetchUser())
    }
}