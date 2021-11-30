package com.mustafafidan.marvel.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mustafafidan.marvel.constants.PAGE_SIZE
import com.mustafafidan.marvel.repository.pagingsource.CharactersPagingSource
import com.mustafafidan.marvel.usecase.FetchCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchCharactersUseCase: FetchCharactersUseCase
) : ViewModel(){
    val flow = Pager(PagingConfig(pageSize = PAGE_SIZE)) { CharactersPagingSource(fetchCharactersUseCase) }.flow.cachedIn(viewModelScope)
}