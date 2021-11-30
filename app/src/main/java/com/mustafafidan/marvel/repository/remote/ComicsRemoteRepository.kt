package com.mustafafidan.marvel.repository.remote

import com.mustafafidan.marvel.model.remote.BaseRemoteEntity
import com.mustafafidan.marvel.model.remote.ComicsEntity
import com.mustafafidan.marvel.network.MarvelService
import retrofit2.Response
import javax.inject.Inject

class ComicsRemoteRepository@Inject constructor(
    private val marvelService: MarvelService
) : ComicsSource.Remote {
    override suspend fun fetchComics(characterId : String,limit : Int): Response<BaseRemoteEntity<ComicsEntity>> = marvelService.getCharacterComics(characterId,limit)
}