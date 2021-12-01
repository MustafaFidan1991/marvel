package com.mustafafidan.marvel.ui.detail

import android.content.Context
import android.view.View
import androidx.fragment.app.findFragment
import com.mustafafidan.marvel.R
import com.mustafafidan.marvel.errorhandling.Error
import com.mustafafidan.marvel.errorhandling.Loading
import com.mustafafidan.marvel.errorhandling.Resource
import com.mustafafidan.marvel.errorhandling.Success
import com.mustafafidan.marvel.model.local.DetailUiModel
import com.mustafafidan.marvel.ui.detail.adapter.ComicAdapter

class DetailViewState(
    private val resource: Resource<*>,
    val data: DetailUiModel?
) {

    fun getName() = data?.character?.name

    fun getDescription() = data?.character?.description

    fun getDescriptionVisibility() = if(data?.character?.description.isNullOrEmpty())  View.GONE else View.VISIBLE

    fun getImage() = data?.character?.imageUrl

    fun getModifiedDate() = data?.character?.modifiedDate

    fun comicsCount(context : Context) = data?.character?.comicsCount?.toString()?.let { context.getString(R.string.comics_count,it) }

    fun getProgressStatus() : Int {
        return when(resource){
            is Success,is Error ->{
                View.GONE
            }
            is Loading -> {
                View.VISIBLE
            }
        }
    }


    fun getAdapter() : ComicAdapter?{
        return data?.comics?.let { ComicAdapter(it) }
    }


    fun onBackClicked(view : View) {
        view.findFragment<DetailFragment>().requireActivity().onBackPressed()
    }

}