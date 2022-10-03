package com.roomdb.app.model.local.room

import androidx.room.*

@Dao
interface PostDao {
    //Insert or replace a post to posts_table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostEntity)

    //SQL Query for get all the posts from posts_table
    @Query("select * from posts_table")
    suspend fun getPosts() :List<PostEntity>

    //SQL Query for delete all the posts from posts_table
    @Query("delete from posts_table")
    suspend fun deleteAllPosts()
}