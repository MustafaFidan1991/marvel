package com.mustafafidan.marvel.model.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersEntity(
    @Json(name = "count")
    val count: Int,
    @Json(name = "limit")
    val limit: Int,
    @Json(name = "offset")
    val offset: Int,
    @Json(name = "results")
    val results: List<CharacterResult>,
    @Json(name = "total")
    val total: Int
) : BaseEntity()