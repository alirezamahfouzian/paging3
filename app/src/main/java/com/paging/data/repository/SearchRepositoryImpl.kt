package com.paging.data.repository

import com.paging.common.network.ResponseHandler.safeApiCall
import com.paging.data.remote.api.SearchMoviesApi
import com.paging.data.remote.dto.MovieDataDto
import com.paging.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchMoviesApi: SearchMoviesApi) :
    SearchRepository {

    override suspend fun searchMovies(query: String): com.paging.common.network.ApiResponse<MovieDataDto> = safeApiCall {
        searchMoviesApi.searchMovies(query)
    }
}