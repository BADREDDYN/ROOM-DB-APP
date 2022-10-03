package com.roomdb.app.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.roomdb.app.model.local.room.PostEntity
import com.roomdb.app.model.local.room.PostsDatabase
import com.roomdb.app.repositories.local.room.PostsRepositoryImp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val postDao = PostsDatabase.mGetInstance(application).postDao()
    private var postsRepositoryImp = PostsRepositoryImp(postDao)

    private val _getPostsMutableStateFlow = MutableStateFlow<List<PostEntity>>(emptyList())
    val getPostsMutableStateFlow = _getPostsMutableStateFlow.asStateFlow()

    fun insertPost(post:PostEntity) {
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