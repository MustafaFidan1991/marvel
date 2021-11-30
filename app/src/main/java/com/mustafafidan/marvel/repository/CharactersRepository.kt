package com.mustafafidan.marvel.repository

import com.mustafafidan.marvel.common.remote
import com.mustafafidan.marvel.repository.remote.CharactersRemoteRepository
import javax.inject.Inject

class CharactersRepository@Inject constructor(
    private val remote: CharactersRemoteRepository
) {
    suspend fun fetchCharacters(limit : Int,offset : Int) = remote.fetchCharacters(limit,offset).remote()

}