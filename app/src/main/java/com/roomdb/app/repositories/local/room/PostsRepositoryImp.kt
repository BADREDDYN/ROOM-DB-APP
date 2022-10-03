package com.roomdb.app.repositories.local.room

import com.roomdb.app.model.local.room.PostDao
import com.roomdb.app.model.local.room.PostEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostsRepositoryImp(private val postDao: PostDao) : PostsRepository {
    override suspend fun insertPost(post: PostEntity) {
        withContext(Dispatchers.IO) {
            postDao.insertPost(post)
        }
    }

    override suspend fun getPosts() =
        withContext(Dispatchers.IO) {
            postDao.getPosts()
        }

    override suspend fun deleteAllPosts() {
        withContext(Dispatchers.IO) {
            postDao.deleteAllPosts()
        }
    }
}