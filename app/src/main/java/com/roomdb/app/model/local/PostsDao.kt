package com.roomdb.app.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostsDao {
    @Insert
    fun insertPost(post: PostEntity)
    @Query("select * from posts_table;")
    fun getPosts() :List<PostEntity>
}