package com.mustafafidan.marvel.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafafidan.marvel.errorhandling.Success
import com.mustafafidan.marvel.model.local.DetailUiModel
import com.mustafafidan.marvel.usecase.FetchDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel@Inject constructor(
    private val fetchDetailUseCase: FetchDetailUseCase
) : ViewModel(){
    private val detailViewState = MutableLiveData<DetailViewState>()

    fun getDetailViewState(): LiveData<DetailViewState> = detailViewState

    fun fetchData(){
        viewModelScope.launch {
            fetchDetailUseCase.fetchData {
                detailViewState.value = DetailViewState(it,(it as? Success<DetailUiModel>)?.successData)
            }
        }
    }
}