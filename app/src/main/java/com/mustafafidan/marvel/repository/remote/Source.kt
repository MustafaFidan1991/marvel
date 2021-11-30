package com.mustafafidan.marvel.repository.remote

import com.mustafafidan.marvel.model.remote.BaseRemoteEntity
import com.mustafafidan.marvel.model.remote.CharactersEntity
import retrofit2.Response


object Source {

    interface Remote {
        suspend fun fetchCharacters(): Response<BaseRemoteEntity<CharactersEntity>>
    }
}