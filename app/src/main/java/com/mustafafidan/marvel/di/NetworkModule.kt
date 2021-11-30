package com.mustafafidan.marvel.di

import com.mustafafidan.marvel.constants.BASE_URL
import com.mustafafidan.marvel.network.MarvelService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @Provides
    fun provideMarvelService(moshiConverterFactory: MoshiConverterFactory): MarvelService {
        return Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }).build())
            .addConverterFactory(moshiConverterFactory)
            .baseUrl(BASE_URL)
            .build()
            .create(MarvelService::class.java)
    }

    @Provides
    fun provideMoshi() : MoshiConverterFactory = MoshiConverterFactory.create(
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build())
}