package com.roomdb.app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roomdb.app.model.local.room.PostEntity
import com.roomdb.app.repositories.local.room.PostsRepositoryImp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val postsRepositoryImp:PostsRepositoryImp
) : ViewModel() {

    private val _getPostsMutableStateFlow = MutableStateFlow<List<PostEntity>>(emptyList())
    val getPostsMutableStateFlow = _getPostsMutableStateFlow.asStateFlow()

    fun insertPost(post: PostEntity) {
        viewModelScope.launch {
            postsRepositoryImp.insertPost(post)
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            _getPostsMutableStateFlow.value = postsRepositoryImp.getPosts()
        }
    }

    fun deleteAllPosts() {
        viewModelScope.launch {
            postsRepositoryImp.deleteAllPosts()
        }
    }
}