package com.paging.presentation.search.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.paging.databinding.RowSearchMovieBinding
import com.paging.common.ui.GenericRecAdapter
import com.paging.domain.model.Movie

class SearchMoviesRecAdapter : GenericRecAdapter<Movie>() {

    override fun getViewHolder(
        parent: ViewGroup,
        layoutInflater: LayoutInflater
    ): ViewHolder<Movie> {
        val binding = RowSearchMovieBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(
            binding,
            bind = { model, _ ->
                binding.movie = model
            }
        )
    }
}