package com.mustafafidan.marvel.model.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "extension")
    val extension: String,
    @Json(name = "path")
    val path: String
)