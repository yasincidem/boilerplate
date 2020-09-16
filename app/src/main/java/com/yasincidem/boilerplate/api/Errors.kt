package com.yasincidem.boilerplate.api

sealed class Errors : Throwable() {
    data class NetworkError(val code: Int? = -1, val desc: String? = "") : Errors()
}