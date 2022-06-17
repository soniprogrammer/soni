package com.example.retrofitmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvm.model.DummyDataItem
import com.example.retrofitmvvm.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.getPosts()

        }

    }

    val posts : LiveData<List<DummyDataItem>>
    get() = postRepository.posts
}