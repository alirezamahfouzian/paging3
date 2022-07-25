package com.paging.domain.use_case

import com.paging.common.network.ResponseHandler.genericFlowResponse
import com.paging.data.remote.dto.toMovie
import com.paging.domain.model.Post
import com.paging.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: SearchRepository
) {

    suspend operator fun invoke(query: String): Flow<com.paging.common.network.ApiResponse<List<Post?>>> =
        genericFlowResponse(repository.searchMovies(query)) { moviesDataDto ->
            moviesDataDto?.data?.videos?.map { it?.toMovie() }
        }
}