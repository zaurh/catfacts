package com.example.catfacts.data.repository


import com.example.catfacts.data.remote.RetrofitApi
import com.example.catfacts.data.remote.dto.PostsDto
import com.example.catfacts.data.remote.dto.SpecificDto
import com.example.catfacts.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: RetrofitApi
): Repository {
    override suspend fun getPosts(): List<PostsDto> {
        return api.getPosts()
    }

    override suspend fun getSpecific(id: String): SpecificDto {
        return api.getSpecific(id)
    }
}