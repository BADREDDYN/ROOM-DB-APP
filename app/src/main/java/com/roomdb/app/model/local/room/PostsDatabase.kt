package com.roomdb.app.model.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val mDATABASE_NAME = "posts_database"

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class PostsDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        @Volatile
        private var mInstance: PostsDatabase? = null

        fun mGetInstance(mContext: Context): PostsDatabase =
            mInstance ?: synchronized(Any()) {
                mInstance ?: mBuildDatabase(mContext).also { mInstance = it }
            }

        private fun mBuildDatabase(mContext: Context): PostsDatabase =
            Room.databaseBuilder(
                mContext.applicationContext, PostsDatabase::class.java,
                mDATABASE_NAME
            ).fallbackToDestructiveMigration().build()
    }

}