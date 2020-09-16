package com.yasincidem.boilerplate.core.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import ru.beryukhov.reactivenetwork.ReactiveNetwork


open class BaseViewModel : ViewModel() {

    val internetConnection = liveData<Boolean> {
        emitSource(ReactiveNetwork().observeInternetConnectivity().asLiveData(Dispatchers.Default))
    }

}