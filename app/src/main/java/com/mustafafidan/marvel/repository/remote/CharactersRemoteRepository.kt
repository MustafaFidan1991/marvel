package com.mustafafidan.marvel.repository.remote

import com.mustafafidan.marvel.model.remote.BaseRemoteEntity
import com.mustafafidan.marvel.model.remote.CharactersEntity
import com.mustafafidan.marvel.network.MarvelService
import retrofit2.Response
import javax.inject.Inject

class CharactersRemoteRepository@Inject constructor(
    private val marvelService: MarvelService
) : Source.Remote {
    override suspend fun fetchCharacters(): Response<BaseRemoteEntity<CharactersEntity>> = marvelService.getCharacters()
}