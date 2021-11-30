package com.mustafafidan.marvel.model.local

data class ComicsUiModel(
    val id : String,
    val name : String,
    val description : String?,
    val imageUrl : String
) : BaseUiModel()