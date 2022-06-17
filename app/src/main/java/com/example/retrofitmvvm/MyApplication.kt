package com.example.retrofitmvvm

import android.app.Application
import com.example.retrofitmvvm.api.ApiInterface
import com.example.retrofitmvvm.api.ApiUtilities
import com.example.retrofitmvvm.repository.PostRepository


class MyApplication : Application() {
   lateinit var postRepository:PostRepository
    override fun onCreate() {
        super.onCreate()

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)

        postRepository = PostRepository(apiInterface)
    }
}