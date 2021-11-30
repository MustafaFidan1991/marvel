package com.mustafafidan.marvel.repository

import com.mustafafidan.marvel.common.remote
import com.mustafafidan.marvel.errorhandling.Loading
import com.mustafafidan.marvel.repository.remote.ComicsRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ComicsRepository@Inject constructor(
    private val remote: ComicsRemoteRepository
) {
    suspend fun fetchComics(characterId : String,limit : Int) = flow {
        emit(Loading())
        emit(remote.fetchComics(characterId,limit).remote())
    }.flowOn(Dispatchers.IO)
}