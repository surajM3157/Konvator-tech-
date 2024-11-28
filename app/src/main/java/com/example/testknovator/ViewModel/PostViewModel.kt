package com.example.testknovator.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testknovator.Model.Post
import com.example.testknovator.Service.RetrofitClient
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    private val _selectedPost = MutableLiveData<Post>()
    val selectedPost: LiveData<Post> get() = _selectedPost

    fun fetchPosts() {
        viewModelScope.launch {
            val response = RetrofitClient.apiService.getPosts()
            if (response.isSuccessful) {
                _posts.postValue(response.body())
            }
        }
    }

    fun fetchPostDetail(postId: Int) {
        viewModelScope.launch {
            val response = RetrofitClient.apiService.getPostDetail(postId)
            if (response.isSuccessful) {
                _selectedPost.postValue(response.body())
            }
        }
    }
}
