package com.yasincidem.boilerplate.ui.main.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.yasincidem.boilerplate.repository.impl.HomeRepository

class HomeViewModel  @ViewModelInject constructor(
    private val repository: HomeRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val text = liveData {
        emit("This is home Fragment")
    }
}