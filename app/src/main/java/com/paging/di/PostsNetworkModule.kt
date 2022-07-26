package com.paging.di

import com.paging.data.remote.api.PostsApi
import com.paging.data.repository.PostsRepositoryImpl
import com.paging.domain.repository.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostsNetworkModule {

    @Provides
    @Singleton
    fun providePostsApi(
        retrofit: Retrofit
    ): PostsApi {
        return retrofit.create(PostsApi::class.java)
    }

    @Provides
    @Singleton
    fun providePostsRepository(api: PostsApi): PostsRepository {
        return PostsRepositoryImpl(api)
    }
}