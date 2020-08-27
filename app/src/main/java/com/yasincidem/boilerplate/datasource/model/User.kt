package com.yasincidem.boilerplate.datasource.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @field:Json(name = "avatar")
    val avatar: String,

    @field:Json(name = "email")
    val email: String,

    @field:Json(name = "id")
    val id: String,

    @field:Json(name = "name")
    val name: String
)