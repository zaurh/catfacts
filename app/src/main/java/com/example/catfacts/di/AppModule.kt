package com.example.catfacts.di

import com.example.catfacts.common.Constants.BASE_URL
import com.example.catfacts.data.remote.RetrofitApi
import com.example.catfacts.data.repository.RepositoryImpl
import com.example.catfacts.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): RetrofitApi {
        return retrofit.create(RetrofitApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: RetrofitApi): Repository {
        return RepositoryImpl(api)
    }
}