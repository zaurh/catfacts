package com.example.catfacts.domain.repository

import com.example.catfacts.data.remote.dto.PostsDto
import com.example.catfacts.data.remote.dto.SpecificDto


interface Repository {

    suspend fun getPosts(): List<PostsDto>

    suspend fun getSpecific(id: String): SpecificDto

}