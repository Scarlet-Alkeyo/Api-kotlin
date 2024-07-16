package com.akirachix.postsapp

import Apiclient
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        fetchPosts()


    }
    fun fetchPosts(){
        var apiInterface= Apiclient.buildApiInterface(PostApiInterface::class.java)
        val  request = apiInterface.getPosts()
        request.enqueue(object :Callback<List<Post>>{
            override fun onResponse(p0: Call<List<Post>>, p1: Response<List<Post>>) {

                if(p1.isSuccessful){
                    var Post=p1.body()
                    Toast.makeText(baseContext,"Fetched ${Post!!.size} Posts" ,Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(p0: Call<List<Post>>, p1: Throwable) {
                Toast.makeText(baseContext,p1.message.toString(),Toast.LENGTH_SHORT).show()

            }

        })


    }
}