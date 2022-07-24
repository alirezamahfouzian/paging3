package com.paging.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.paging.data.remote.api.SearchMoviesApi
import com.paging.data.repository.SearchRepositoryImpl
import com.paging.domain.repository.SearchRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchMoviesNetworkModule {
    @Provides
    @Singleton
    fun provideSearchMoviesApi(
        retrofit: Retrofit
    ): SearchMoviesApi {
        return retrofit.create(SearchMoviesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSearchRepository(api: SearchMoviesApi): SearchRepository {
        return SearchRepositoryImpl(api)
    }
}