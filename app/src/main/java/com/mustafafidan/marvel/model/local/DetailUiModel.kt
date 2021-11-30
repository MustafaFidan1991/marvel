package com.mustafafidan.marvel.model.local

data class DetailUiModel(
    val character : CharacterUiModel,
    val comics : List<ComicsUiModel>?
) : BaseUiModel()