package com.example.retrofitmvvm.api

import com.example.retrofitmvvm.model.DummyDataItem
import com.example.retrofitmvvm.model.Jokes
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getPost(): List<DummyDataItem>

}