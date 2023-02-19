package com.example.catfacts.domain.use_case

import com.example.catfacts.common.Resource
import com.example.catfacts.data.remote.dto.toSpecific
import com.example.catfacts.domain.model.Specific
import com.example.catfacts.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class GetSpecificUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(id: String): Flow<Resource<Specific>> = flow {
        try {
            emit(Resource.Loading())
            val specific = repository.getSpecific(id).toSpecific()
            emit(Resource.Success(specific))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message.toString()))

        }
    }
}