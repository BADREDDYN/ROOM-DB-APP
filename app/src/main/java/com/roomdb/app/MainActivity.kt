package com.roomdb.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.roomdb.app.databinding.ActivityMainBinding
import com.roomdb.app.model.local.PostEntity
import com.roomdb.app.model.local.PostsDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}