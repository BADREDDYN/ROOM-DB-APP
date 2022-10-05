package com.roomdb.app.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.roomdb.app.R
import com.roomdb.app.databinding.ActivityMainBinding
import com.roomdb.app.model.local.room.PostEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding: ActivityMainBinding

    //ViewModel
    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Add random post to posts_table
        binding.btnAddRandomPost.setOnClickListener {
            vm.insertPost(randomPost())
        }
        //Get all the posts from posts_table
        binding.btnGetPosts.setOnClickListener {
            vm.getPosts()
        }
        //Remove all the posts from posts_table
        binding.btnRemoveAllPosts.setOnClickListener {
            vm.deleteAllPosts()
        }

        //Observing the posts by StateFlow
        lifecycleScope.launchWhenStarted {
            vm.getPostsMutableStateFlow.collectLatest { postsList ->
                "Fire!".shortToast()

                if (postsList.isNotEmpty()) {
                    postsList.forEach {
                        "${it.id} ${it.userId} ${it.title} ${it.body}.".shortSnackBar()
                        delay(1000)
                    }
                }
            }
        }


    }

    //Generate a random post
    private fun randomPost(): PostEntity {
        val userId = randomInt(1..100)
        val postNumber = randomInt(1..10000)
        return PostEntity(0, userId, "Title$postNumber", "Body$postNumber.")
    }

    //Generate a random Int
    private fun randomInt(range: IntRange) = Random.nextInt(range.first, range.last)

    //Extension function for short SnackBar
    private fun String.shortSnackBar() {
        Snackbar.make(binding.root, this, Snackbar.LENGTH_SHORT).show()
    }

    //Extension function for short Toast
    private fun String.shortToast() {
        Toast.makeText(this@MainActivity, this, Toast.LENGTH_SHORT).show()
    }
}