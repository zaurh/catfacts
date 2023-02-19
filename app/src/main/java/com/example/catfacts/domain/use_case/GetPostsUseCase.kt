package com.example.catfacts.domain.use_case

import com.example.catfacts.common.Resource
import com.example.catfacts.data.remote.dto.toPosts
import com.example.catfacts.domain.model.Posts
import com.example.catfacts.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(): Flow<Resource<List<Posts>>> = flow {
        try {
            emit(Resource.Loading())
            val posts = repository.getPosts().map { it.toPosts() }
            emit(Resource.Success(posts))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message.toString()))

        }
    }
}