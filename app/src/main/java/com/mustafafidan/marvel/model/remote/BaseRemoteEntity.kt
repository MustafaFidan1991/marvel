package com.mustafafidan.marvel.model.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseRemoteEntity<T>(
    @Json(name = "attributionHTML")
    val attributionHTML: String,
    @Json(name = "attributionText")
    val attributionText: String,
    @Json(name = "code")
    val code: Int,
    @Json(name = "status")
    val status: String?,
    @Json(name = "copyright")
    val copyright: String,
    @Json(name = "data")
    val `data`: T,
    @Json(name = "etag")
    val etag: String,
)