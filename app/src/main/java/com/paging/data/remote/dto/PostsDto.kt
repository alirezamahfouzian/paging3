package com.paging.data.remote.dto

data class PostsDto(
    val data: List<PostDataDto?>? = null,
    val limit: Int? = null,
    val page: Int? = null,
    val total: Int? = null
)