package com.yasincidem.boilerplate.ui.main.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import com.yasincidem.boilerplate.core.base.viewmodel.BaseViewModel
import com.yasincidem.boilerplate.core.util.ResultOf
import com.yasincidem.boilerplate.datasource.model.User
import com.yasincidem.boilerplate.repository.impl.HomeRepository

class HomeViewModel  @ViewModelInject constructor(
    private val repository: HomeRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    val text = liveData {
        emit("This is home Fragment")
    }

    val user: LiveData<ResultOf<List<User>>> = liveData {
        emit(repository.fetchUser())
    }
}