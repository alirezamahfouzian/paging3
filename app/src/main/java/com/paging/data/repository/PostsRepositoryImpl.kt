package com.paging.data.repository

import com.paging.common.network.ApiResponse
import com.paging.common.network.ResponseHandler.safeApiCall
import com.paging.data.remote.api.PostsApi
import com.paging.data.remote.dto.PostsDto
import com.paging.domain.repository.PostsRepository
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val postsApi: PostsApi) : PostsRepository {

    override suspend fun getPosts(): ApiResponse<PostsDto> = safeApiCall {
        postsApi.getPosts()
    }
}