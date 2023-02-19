package com.example.catfacts.data.remote


import com.example.catfacts.data.remote.dto.PostsDto
import com.example.catfacts.data.remote.dto.SpecificDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {

    @GET("posts")
    suspend fun getPosts(): List<PostsDto>

    @GET("posts/{id}")
    suspend fun getSpecific(
        @Path("id") id: String
    ): SpecificDto
}

