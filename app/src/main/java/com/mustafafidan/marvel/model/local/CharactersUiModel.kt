package com.mustafafidan.marvel.model.local

data class CharactersUiModel(
    val offset : Int,
    val characters : List<CharacterUiModel>?
) : BaseUiModel()