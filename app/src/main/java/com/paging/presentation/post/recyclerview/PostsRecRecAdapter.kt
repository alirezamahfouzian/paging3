package com.paging.presentation.post.recyclerview

import com.example.paging.R
import com.example.paging.databinding.RowPostsBinding
import com.paging.common.ui.BaseRecAdapter
import com.paging.domain.model.Post

class PostsRecRecAdapter : BaseRecAdapter<RowPostsBinding, Post>() {

    override val layoutId: Int
        get() = R.layout.row_posts

    override fun bind(binding: RowPostsBinding, item: Post) {
        binding.apply {
            post = item
            executePendingBindings()
        }
    }
}
