package com.paging.data.remote.api

import com.paging.common.constants.search.SearchApiConstants.SEARCH_API_ENDPOINT
import com.paging.common.constants.search.SearchApiConstants.SEARCH_API_PARAM_QUERY
import com.paging.data.remote.dto.MovieDataDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchMoviesApi {

    @GET(SEARCH_API_ENDPOINT)
    suspend fun searchMovies(
        @Query(SEARCH_API_PARAM_QUERY) query: String
    ): Response<MovieDataDto>
}