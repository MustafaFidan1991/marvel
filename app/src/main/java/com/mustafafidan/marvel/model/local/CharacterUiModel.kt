package com.mustafafidan.marvel.model.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterUiModel(
    val id : Int,
    val name : String,
    val imageUrl : String,
    val description : String,
    val modifiedDate : String,
    val comicsCount : Int
): BaseUiModel(), Parcelable