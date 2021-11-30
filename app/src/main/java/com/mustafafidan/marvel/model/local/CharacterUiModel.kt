package com.mustafafidan.marvel.model.local

data class CharacterUiModel(
    val id : Int,
    val name : String,
    val imageUrl : String,
    val description : String,
    val modifiedDate : String,
    val comicsCount : Int
)