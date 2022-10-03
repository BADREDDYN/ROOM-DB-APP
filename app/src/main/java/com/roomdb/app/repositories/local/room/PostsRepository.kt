package com.roomdb.app.repositories.local.room

import com.roomdb.app.model.local.room.PostEntity

interface PostsRepository {
    suspend fun insertPost(post: PostEntity)

    suspend fun getPosts(): List<PostEntity>

    suspend fun deleteAllPosts()
}