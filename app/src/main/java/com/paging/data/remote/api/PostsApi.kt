package com.paging.data.remote.api

import com.paging.common.constants.post.PostsApiConstants.POST_API_ENDPOINT
import com.paging.common.constants.post.PostsApiConstants.POST_API_PARAM_PAGE
import com.paging.data.remote.dto.PostsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsApi {

    @GET(POST_API_ENDPOINT)
    suspend fun getPosts(
        @Query(POST_API_PARAM_PAGE) query: String
    ): Response<PostsDto>
}