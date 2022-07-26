package com.paging.presentation.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paging.common.network.ApiResponse
import com.paging.domain.model.Post
import com.paging.domain.use_case.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _postList = MutableLiveData<List<Post?>?>()
    val postList: LiveData<List<Post?>?> = _postList

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    var postsApiJob: Job? = null
    private fun getPosts(query: String) {
        postsApiJob?.cancel()
        postsApiJob = viewModelScope.launch(IO) {
            getPostsUseCase(query).collect {
                when (it) {
                    is ApiResponse.Error -> {
                        _isLoading.postValue(false)
                    }
                    is ApiResponse.Loading -> {
                        _isLoading.postValue(true)
                    }
                    is ApiResponse.Success -> {
                        _postList.postValue(it.data)
                        _isLoading.postValue(false)
                    }
                }
            }
        }
    }
}