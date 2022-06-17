package com.example.retrofitmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvm.api.ApiInterface
import com.example.retrofitmvvm.model.DummyDataItem
import com.example.retrofitmvvm.model.Jokes


class PostRepository (private val apiInterface: ApiInterface){

    private val postsLiveData = MutableLiveData<List<DummyDataItem>>()
    val posts : LiveData<List<DummyDataItem>>
    get() = postsLiveData

    suspend fun getPosts(){
        val result = apiInterface.getPost()

        if (result!= null){

           // memesDatabase.memeDao().insertMemes(result.body()!!.data.memes)

            postsLiveData.postValue(result)
        }
    }
}
