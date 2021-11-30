package com.mustafafidan.marvel.ui.detail.adapter

import com.mustafafidan.marvel.model.local.ComicsUiModel

class ComicItemViewState(
    private val comic : ComicsUiModel
) {
    fun getName() = comic.name

    fun getDescription() = comic.description

    fun getImage() = comic.imageUrl
}