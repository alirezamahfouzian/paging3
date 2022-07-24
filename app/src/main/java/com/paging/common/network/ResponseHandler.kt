package com.paging.common.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object ResponseHandler {

    suspend inline fun <T> safeApiCall(
        crossinline requestFunction: suspend () -> Response<T>
    ): com.paging.common.network.ApiResponse<T> {
        return try {
            val response = requestFunction()
            com.paging.common.network.ApiResponse.create(response)
        } catch (e: Exception) {
            com.paging.common.network.ApiResponse.create(e)
        }
    }

    fun <T, U> genericFlowResponse(
        response: com.paging.common.network.ApiResponse<T>,
        successFunction: (T?) -> U?
    ): Flow<com.paging.common.network.ApiResponse<U>> = flow {
        emit(com.paging.common.network.ApiResponse.Loading())
        when (response) {
            is com.paging.common.network.ApiResponse.Error -> {
                emit(com.paging.common.network.ApiResponse.Error(response.errorMessage))
            }
            is com.paging.common.network.ApiResponse.Success -> {
                emit(com.paging.common.network.ApiResponse.Success(successFunction(response.data)))
            }
        }
    }
}