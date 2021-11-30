package com.mustafafidan.marvel.usecase

interface Mapper<T,R> {
    fun mapFromResponse(type: T?) : R
}
