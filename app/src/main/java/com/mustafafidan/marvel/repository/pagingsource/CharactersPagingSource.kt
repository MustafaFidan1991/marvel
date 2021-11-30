package com.mustafafidan.marvel.repository.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mustafafidan.marvel.errorhandling.Error
import com.mustafafidan.marvel.errorhandling.Success
import com.mustafafidan.marvel.model.local.CharacterUiModel
import com.mustafafidan.marvel.usecase.FetchCharactersUseCase

class CharactersPagingSource(
    private val fetchListUseCase: FetchCharactersUseCase
) : PagingSource<Int, CharacterUiModel>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, CharacterUiModel> {
        return try {
            val offset = params.key ?: 0
            when(val result = fetchListUseCase.fetchData(params.loadSize,offset)){
                is Success -> LoadResult.Page(
                    data = result.successData.characters ?: listOf(),
                    prevKey = null,
                    nextKey = result.successData.offset + (result.successData.characters?.size ?: 0)
                )
                is Error -> LoadResult.Error(Throwable(result.errorMessage))
                else -> LoadResult.Error(Throwable())
            }
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterUiModel>): Int? = null
}