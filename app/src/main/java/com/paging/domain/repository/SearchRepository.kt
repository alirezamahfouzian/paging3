package com.paging.domain.repository

import com.paging.data.remote.dto.MovieDataDto

interface SearchRepository {

    suspend fun searchMovies(query: String): com.paging.common.network.ApiResponse<MovieDataDto>
}