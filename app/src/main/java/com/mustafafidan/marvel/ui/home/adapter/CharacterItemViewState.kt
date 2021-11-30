package com.mustafafidan.marvel.ui.home.adapter

import android.content.Context
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.mustafafidan.marvel.R
import com.mustafafidan.marvel.model.local.CharacterUiModel
import com.mustafafidan.marvel.ui.home.HomeFragment

class CharacterItemViewState(
    private val character : CharacterUiModel
) {

    fun getName() = character.name

    fun getDescription() = character.description

    fun getDescriptionVisibility() = if(character.description.isEmpty())  View.GONE else View.VISIBLE

    fun getImage() = character.imageUrl

    fun getModifiedDate() = character.modifiedDate

    fun comicsCount(context : Context) = context.getString(R.string.comics_count,character.comicsCount.toString())

    fun onServiceItemClicked(view : View) {
        view.findFragment<HomeFragment>().findNavController().navigate(R.id.action_homeFragment_to_detailFragment,
            bundleOf("character" to character)
        )
    }
}