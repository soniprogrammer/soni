package com.example.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvm.adapter.PostItemAdapter
import com.example.retrofitmvvm.model.DummyDataItem
import com.example.retrofitmvvm.viewmodel.PostViewModel
import com.example.retrofitmvvm.viewmodel.PostViewModelFactory
import java.util.Locale.filter

class MainActivity : AppCompatActivity() {

   private lateinit var postViewModel: PostViewModel
   private var listView:ListView?=null
   lateinit var searchImg:ImageView
   lateinit var searchEditText: EditText
   private var postItemAdapter:PostItemAdapter?=null
   private var arrayList:ArrayList<DummyDataItem>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.post_list_view)
        searchImg=findViewById(R.id.searching)
        searchEditText=findViewById(R.id.search_edit_text)
        val repository=(application as MyApplication).postRepository
        postViewModel=ViewModelProvider(this,PostViewModelFactory(repository)).get(PostViewModel::class.java)
        postViewModel.posts.observe(this,{

            arrayList= ArrayList(it)

            postItemAdapter=PostItemAdapter(applicationContext,arrayList!!)

            listView?.adapter=postItemAdapter

        })
        setSearchListener()

        searchEditText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                filter(p0.toString())

            }

        })


    }

    private fun filter(text: String) {

        val filterList = ArrayList<DummyDataItem>()

        for (item:DummyDataItem in arrayList!!){

            if(item.title.lowercase().contains(text.lowercase())){

                filterList.addAll(listOf(item))
            }

        }

        postItemAdapter?.filterList(filterList)

    }

    private fun setSearchListener() {
       searchImg.setOnClickListener(View.OnClickListener {
          searchImg.visibility=View.GONE
          searchEditText.visibility=View.VISIBLE
       })


    }


}