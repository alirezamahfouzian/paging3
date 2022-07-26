package com.paging.domain.use_case

import com.paging.common.network.ApiResponse
import com.paging.common.network.ResponseHandler.genericFlowResponse
import com.paging.data.remote.dto.toPost
import com.paging.domain.model.Post
import com.paging.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostsRepository
) {

    suspend operator fun invoke(query: String): Flow<ApiResponse<List<Post?>>> =
        genericFlowResponse(repository.getPosts(query)) { postsDto ->
            postsDto?.data?.map { it?.toPost() }
        }
}