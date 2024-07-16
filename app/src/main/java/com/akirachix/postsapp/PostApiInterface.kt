package com.akirachix.postsapp

import retrofit2.Call
import retrofit2.http.GET

interface PostApiInterface {
    @GET ("Posts")
    fun getPosts():Call<List<Post>>
}