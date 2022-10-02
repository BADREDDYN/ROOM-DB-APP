package com.roomdb.app.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userId: Int,
    var title: String,
    var body: String
)