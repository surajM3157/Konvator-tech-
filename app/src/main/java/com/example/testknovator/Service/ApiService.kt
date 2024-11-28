package com.example.testknovator.Service

import com.example.testknovator.Model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts/{id}")
    suspend fun getPostDetail(@Path("id") postId: Int): Response<Post>
}
