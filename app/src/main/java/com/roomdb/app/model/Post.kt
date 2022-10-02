package com.roomdb.app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class Post(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userId: Int,
    var title: String,
    var body: String
)