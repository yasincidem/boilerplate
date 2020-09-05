package com.yasincidem.boilerplate.ui.main.notifications

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import com.yasincidem.boilerplate.core.base.viewmodel.BaseViewModel
import com.yasincidem.boilerplate.repository.impl.NotificationsRepository

class NotificationsViewModel @ViewModelInject constructor(
    private val repository: NotificationsRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    val text = liveData {
        emit("This is notifications Fragment")
    }
}