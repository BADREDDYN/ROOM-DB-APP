package com.roomdb.app.di

import android.app.Application
import androidx.room.Room
import com.roomdb.app.model.local.room.PostsDatabase
import com.roomdb.app.repositories.local.room.PostsRepositoryImp
import com.roomdb.app.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val mDATABASE_NAME = "posts_database"

val postsDatabaseModule = module {
    fun getDatabaseInstance(application: Application) =
        Room.databaseBuilder(
            application, PostsDatabase::class.java,
            mDATABASE_NAME
        ).build()

    single { getDatabaseInstance(androidApplication()) }
    factory { get<PostsDatabase>().postDao() }
}

val postsRepositoryModule = module {
    single { PostsRepositoryImp(postDao = get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(postsRepositoryImp = get()) }
}