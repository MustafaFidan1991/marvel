package com.mustafafidan.marvel.network

import com.mustafafidan.marvel.constants.API_KEY
import com.mustafafidan.marvel.model.remote.BaseRemoteEntity
import com.mustafafidan.marvel.model.remote.CharactersEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("characters")
    suspend fun getCharacters(@Query("apiKey") apiKey : String = API_KEY): Response<BaseRemoteEntity<CharactersEntity>>


}