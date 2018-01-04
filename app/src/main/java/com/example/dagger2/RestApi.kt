package com.example.dagger2

import retrofit2.Call
import retrofit2.http.GET

interface RestApi {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>
}