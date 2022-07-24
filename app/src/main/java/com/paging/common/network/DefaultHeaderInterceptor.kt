package com.paging.common.network

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
                com.paging.common.constants.ApiConstants.API_HEADER_PLATFORM,
                com.paging.common.constants.ApiConstants.API_HEADER_PLATFORM_VALUE
            ).build()
        return chain.proceed(request)
    }
}