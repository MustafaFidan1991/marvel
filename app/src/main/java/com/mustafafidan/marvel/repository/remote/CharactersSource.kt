package com.mustafafidan.marvel.repository.remote

import com.mustafafidan.marvel.model.remote.BaseRemoteEntity
import com.mustafafidan.marvel.model.remote.CharactersEntity
import retrofit2.Response


object CharactersSource {

    interface Remote {
        suspend fun fetchCharacters(limit : Int,offset : Int): Response<BaseRemoteEntity<CharactersEntity>>
    }
}