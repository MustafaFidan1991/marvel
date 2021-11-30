package com.mustafafidan.marvel.common

import com.mustafafidan.marvel.errorhandling.Loading
import retrofit2.Response
import com.mustafafidan.marvel.errorhandling.Resource
import com.mustafafidan.marvel.errorhandling.Success
import com.mustafafidan.marvel.errorhandling.Error
import com.mustafafidan.marvel.model.local.BaseUiModel
import com.mustafafidan.marvel.model.remote.BaseEntity
import com.mustafafidan.marvel.model.remote.BaseRemoteEntity

fun <T : BaseRemoteEntity<R>,R> Response<T>.remote() : Resource<R> {
    return if(isSuccessful){
        this.body()?.let { body->
            if(body.code == 200){ Success(body.data) }
            else{ Error("api error message : ${body.status}") }
        } ?: run {
            Error("api body error")
        }
    } else {
        Error("server error, error code : ${code()}")
    }
}

fun <T: BaseEntity,R: BaseUiModel> Resource<T>.mapOnData(transform : (T) -> R) : Resource<R> {
    return when(this){
        is Success<T> ->{ Success(transform(this.successData)) }
        is Error -> this
        is Loading -> this
    }
}