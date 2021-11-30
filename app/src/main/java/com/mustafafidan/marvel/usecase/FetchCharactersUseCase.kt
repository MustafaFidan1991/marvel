package com.mustafafidan.marvel.usecase

import android.content.Context
import com.mustafafidan.marvel.common.getFormattedDate
import com.mustafafidan.marvel.common.mapOnData
import com.mustafafidan.marvel.errorhandling.Resource
import com.mustafafidan.marvel.model.local.CharacterUiModel
import com.mustafafidan.marvel.model.local.CharactersUiModel
import com.mustafafidan.marvel.model.remote.CharactersEntity
import com.mustafafidan.marvel.repository.CharactersRepository
import javax.inject.Inject

class FetchCharactersUseCase @Inject constructor(
    private val repository: CharactersRepository,
    private val mapper: FetchCharactersMapper
){
    suspend fun fetchData(limit : Int,offset : Int) : Resource<CharactersUiModel> {
        return repository.fetchCharacters(limit,offset).mapOnData { mapper.mapFromResponse(it) }
    }
}

class FetchCharactersMapper @Inject constructor(
    private val dateFormatter: DateFormatter
) : Mapper<CharactersEntity?, CharactersUiModel> {
    override fun mapFromResponse(response: CharactersEntity?): CharactersUiModel {
        return CharactersUiModel(response?.offset ?: 0,response?.results?.map {
            CharacterUiModel(
                it.id,
                it.name,
                "${it.thumbnail.path}.${it.thumbnail.extension}",
                it.description,
                dateFormatter.provideDate(it.modified),
                it.comics.items.size
            )
        })
    }
}


class DateFormatter @Inject constructor(
    private val context: Context
) {
    fun provideDate(modifiedDate : String) : String = modifiedDate.getFormattedDate(context)
}


