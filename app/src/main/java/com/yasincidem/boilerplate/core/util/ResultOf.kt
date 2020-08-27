package com.yasincidem.boilerplate.core.util

import com.yasincidem.boilerplate.core.base.viewstate.IViewState

sealed class ResultOf<out T> : IViewState {

    companion object {
        fun <T> success(result: T): ResultOf<T> = Success(result)
        fun <T> failure(error: Throwable): ResultOf<T> = Failure(error)
    }

    data class Failure(val error: Throwable) : ResultOf<Nothing>()
    data class Success<out T>(val data: T) : ResultOf<T>()
}