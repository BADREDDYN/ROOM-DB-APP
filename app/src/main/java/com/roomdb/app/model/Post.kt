package com.roomdb.app.model

data class Post(
    val id: Int,
    val userId: Int,
    var title: String,
    var body: String
)