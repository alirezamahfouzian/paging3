package com.paging.data.remote.dto

import com.paging.domain.model.Post

data class PostDataDto(
    val id: String? = null,
    val image: String? = null,
    val likes: Int? = null,
    val postOwnerDto: PostOwnerDto? = null,
    val publishDate: String? = null,
    val tags: List<String?>? = null,
    val text: String? = null
)

fun PostDataDto.toPost(): Post = Post(
    id = id,
    image = image,
    likes = likes,
    publishDate = publishDate,
    tags = tags,
    text = text,
)
