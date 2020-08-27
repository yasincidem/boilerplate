package com.yasincidem.boilerplate.core.functional

typealias Supplier<T> = () -> T

interface Consumer<T> {
    fun accept(t: T)
}