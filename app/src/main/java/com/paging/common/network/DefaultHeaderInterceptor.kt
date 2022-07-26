package com.paging.common.network

import com.paging.common.constants.ApiConstants.API_HEADER_APP_ID
import com.paging.common.constants.ApiConstants.API_HEADER_APP_ID_VALUE
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultHeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request =
            chain.request().newBuilder().addHeader(
                API_HEADER_APP_ID,
                API_HEADER_APP_ID_VALUE
            ).build()
        return chain.proceed(request)
    }
}