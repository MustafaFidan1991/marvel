package com.mustafafidan.marvel.common

import com.mustafafidan.marvel.errorhandling.Loading
import retrofit2.Response
import com.mustafafidan.marvel.errorhandling.Resource
import com.mustafafidan.marvel.errorhandling.Success
import com.mustafafidan.marvel.errorhandling.Error

fun <T> Response<T>.remote() : Resource<T> {
    return if(isSuccessful){
        this.body()?.let { body->
            Success(body)
        } ?: run {
            Error("api body error")
        }
    } else {
        Error("server error, error code : ${code()}")
    }
}

fun <T: BaseModel,R: BaseUiModel> Resource<T>.mapOnData(transform : (T) -> R) : Resource<R> {
    return when(this){
        is Success<T> ->{
            Success(transform(this.successData))
        }
        is Error -> this
        is Loading -> this
    }
}