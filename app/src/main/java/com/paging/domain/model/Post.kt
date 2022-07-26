package com.paging.domain.model

import com.paging.data.remote.dto.PostOwnerDto


data class Post(
    val id: String? = null,
    val image: String? = null,
    val likes: Int? = null,
    val publishDate: String? = null,
    val tags: List<String?>? = null,
    val text: String? = null
)