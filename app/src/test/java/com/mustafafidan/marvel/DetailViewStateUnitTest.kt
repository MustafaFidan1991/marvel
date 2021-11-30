package com.mustafafidan.marvel

import android.view.View
import com.mustafafidan.marvel.errorhandling.Success
import com.mustafafidan.marvel.model.local.CharacterUiModel
import com.mustafafidan.marvel.model.local.DetailUiModel
import com.mustafafidan.marvel.ui.detail.DetailViewState
import org.junit.Assert.assertEquals
import org.junit.Test

class DetailViewStateUnitTest {

    @Test
    fun whenResourceSuccessProgressBarShouldBeGone(){
        //Given
        val successData = Success(DetailUiModel(CharacterUiModel(0,"","","","",0),null))
        val homeViewState = DetailViewState(successData,null)
        //When
        val progressBarVisibleStatus = homeViewState.getProgressStatus()
        //Then
        assertEquals(progressBarVisibleStatus, View.GONE)
    }

}