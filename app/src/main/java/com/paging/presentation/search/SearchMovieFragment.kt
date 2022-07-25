package com.paging.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.paging.databinding.FragmentSearchMovieBinding
import com.paging.presentation.search.recyclerview.SearchMoviesRecRecAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchMovieFragment : Fragment() {

    private var _binding: FragmentSearchMovieBinding? = null
    private val binding get() = _binding!!

    private val searchMovieViewModel: SearchMovieViewModel by activityViewModels()

    private val searchMoviesRecAdapter by lazy { SearchMoviesRecRecAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchMovieBinding.inflate(inflater, container, false)
        binding.viewModel = searchMovieViewModel
        binding.adapter = searchMoviesRecAdapter
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}