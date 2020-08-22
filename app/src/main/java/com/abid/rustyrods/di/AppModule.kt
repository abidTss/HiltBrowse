package com.abid.rustyrods.di

import com.abid.rustyrods.api.ApiService
import com.abid.rustyrods.utils.LiveDataCallAdapterFactory
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by abid on 15,August,2020
 */

@InstallIn(ApplicationComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideApiService():ApiService{
        return  Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(ApiService::class.java)
    }
}