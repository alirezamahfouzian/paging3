package com.paging.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.paging.domain.model.Movie
import com.paging.domain.use_case.SearchMoviesUseCase
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

    private val _searchQueryResult = MutableStateFlow<List<Movie?>?>(emptyList())
    val searchQueryResult: StateFlow<List<Movie?>?> = _searchQueryResult

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    val searchQueryText = MutableStateFlow("")

    init {
        getSearchQueryState()
    }

    private fun getSearchQueryState() {
        searchQueryText.onEach {
            searchMovies(it)
        }.launchIn(viewModelScope)
    }

    var searchJob: Job? = null
    private fun searchMovies(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch(IO) {
            searchMoviesUseCase(query).collect {
                when (it) {
                    is com.paging.common.network.ApiResponse.Error -> {
                        _isLoading.postValue(false)
                    }
                    is com.paging.common.network.ApiResponse.Loading -> {
                        _isLoading.postValue(true)
                    }
                    is com.paging.common.network.ApiResponse.Success -> {
                        _searchQueryResult.value = it.data
                        _isLoading.postValue(false)
                    }
                }
            }
        }
    }
}