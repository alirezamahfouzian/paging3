package com.paging.common.network

import com.paging.common.network.error_msg.NetworkGeneralError.GENERAL_ERROR_MSG
import retrofit2.Response

sealed class ApiResponse<T> {

    companion object {
        fun <T> create(error: Throwable): com.paging.common.network.ApiResponse.Error<T> {
            return com.paging.common.network.ApiResponse.Error(
                errorMessage = error.message ?: GENERAL_ERROR_MSG
            )
        }

        fun <T> create(response: Response<T>): com.paging.common.network.ApiResponse<T> {
            return if (response.isSuccessful) {
                com.paging.common.network.ApiResponse.Success(data = response.body())
            } else {
                com.paging.common.network.ApiResponse.Error(
                    errorMessage = GENERAL_ERROR_MSG
                )
            }
        }
    }

    class Loading<T> : com.paging.common.network.ApiResponse<T>()
    data class Success<T>(val data: T?) : com.paging.common.network.ApiResponse<T>()
    data class Error<T>(val errorMessage: String) : com.paging.common.network.ApiResponse<T>()
}
