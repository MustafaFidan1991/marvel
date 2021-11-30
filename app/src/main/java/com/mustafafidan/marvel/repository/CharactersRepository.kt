package com.mustafafidan.marvel.repository

import com.mustafafidan.marvel.common.remote
import com.mustafafidan.marvel.errorhandling.Loading
import com.mustafafidan.marvel.repository.remote.CharactersRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharactersRepository@Inject constructor(
    private val remote: CharactersRemoteRepository
) {
    suspend fun fetchCharacters() = flow {
        emit(Loading())
        emit(remote.fetchCharacters().remote())
    }.flowOn(Dispatchers.IO)

}