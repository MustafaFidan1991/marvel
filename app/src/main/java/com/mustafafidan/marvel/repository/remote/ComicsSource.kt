package com.mustafafidan.marvel.repository.remote

import com.mustafafidan.marvel.model.remote.BaseRemoteEntity
import com.mustafafidan.marvel.model.remote.ComicsEntity
import retrofit2.Response


object ComicsSource {

    interface Remote {
        suspend fun fetchComics(characterId : String,limit : Int): Response<BaseRemoteEntity<ComicsEntity>>
    }
}