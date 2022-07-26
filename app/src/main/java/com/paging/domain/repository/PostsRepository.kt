package com.paging.domain.repository

import com.paging.common.network.ApiResponse
import com.paging.data.remote.dto.PostsDto

interface PostsRepository {

    suspend fun getPosts(): ApiResponse<PostsDto>
}