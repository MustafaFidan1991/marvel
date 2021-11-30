package com.mustafafidan.marvel.usecase

import androidx.lifecycle.SavedStateHandle
import com.mustafafidan.marvel.common.mapOnData
import com.mustafafidan.marvel.errorhandling.Resource
import com.mustafafidan.marvel.model.local.CharacterUiModel
import com.mustafafidan.marvel.model.local.ComicsUiModel
import com.mustafafidan.marvel.model.local.DetailUiModel
import com.mustafafidan.marvel.model.remote.ComicsEntity
import com.mustafafidan.marvel.repository.ComicsRepository
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class FetchDetailUseCase @Inject constructor(
    private val repository: ComicsRepository,
    private val savedStateHandle: SavedStateHandle,
    private val mapper: FetchDetailMapper
){
    private val comicLimit = 10
    suspend fun fetchData(transform : (Resource<DetailUiModel>) -> Unit) {
        val characterUiModel = savedStateHandle.get<CharacterUiModel>("character")!!
        repository.fetchComics(characterUiModel.id.toString(),comicLimit).collect {
            transform(it.mapOnData { mapper.mapFromResponse(it) })
        }
    }
}

class FetchDetailMapper @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : Mapper<ComicsEntity?, DetailUiModel> {
    override fun mapFromResponse(type: ComicsEntity?): DetailUiModel {
        val characterUiModel = savedStateHandle.get<CharacterUiModel>("character")!!
        return DetailUiModel(
            character = characterUiModel,
            comics = type?.results?.map {
                ComicsUiModel(
                    it.id.toString(),
                    it.title,
                    it.description,
                    "${it.thumbnail.path}.${it.thumbnail.extension}"
                )
            }
        )
    }
}



