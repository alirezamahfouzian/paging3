package com.paging.presentation.search.recyclerview

import com.example.paging.R
import com.example.paging.databinding.RowSearchMovieBinding
import com.paging.common.ui.BaseRecAdapter
import com.paging.domain.model.Post

class SearchMoviesRecRecAdapter() : BaseRecAdapter<RowSearchMovieBinding, Post>() {

    override val layoutId: Int
        get() = R.layout.row_search_movie

    override fun bind(binding: RowSearchMovieBinding, item: Post) {
        binding.apply {
            movie = item
            executePendingBindings()
        }
    }
}
