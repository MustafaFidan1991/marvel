package com.mustafafidan.marvel.network

import com.mustafafidan.marvel.common.md5
import com.mustafafidan.marvel.common.timeStamp
import com.mustafafidan.marvel.constants.API_KEY
import com.mustafafidan.marvel.constants.PRIVATE_KEY
import com.mustafafidan.marvel.model.remote.BaseRemoteEntity
import com.mustafafidan.marvel.model.remote.CharactersEntity
import com.mustafafidan.marvel.model.remote.ComicsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {

    @GET("characters")
    suspend fun getCharacters(
        @Query("limit")limit : Int,
        @Query("offset") offset : Int,
        @Query("ts") ts : String = timeStamp(),
        @Query("apikey") apikey : String = API_KEY,
        @Query("hash") hash : String = "${timeStamp()}$PRIVATE_KEY$API_KEY".md5()
    ): Response<BaseRemoteEntity<CharactersEntity>>

    @GET("characters/{characterId}/comics")
    suspend fun getCharacterComics(
        @Path("characterId") characterId: String,
        @Query("limit")limit : Int,
        @Query("dateRange") dateRange : String = "2005-01-01,2025-01-01",
        @Query("ts") ts : String = timeStamp(),
        @Query("apikey") apikey : String = API_KEY,
        @Query("hash") hash : String = "${timeStamp()}$PRIVATE_KEY$API_KEY".md5()
    ): Response<BaseRemoteEntity<ComicsEntity>>

}