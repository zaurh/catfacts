package com.example.catfacts.presentation.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catfacts.common.Resource
import com.example.catfacts.domain.use_case.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val useCase: GetPostsUseCase
):ViewModel() {

    private val _state = mutableStateOf(ListState())
        val state: State<ListState> = _state

    init {
        getPosts()
    }
    private fun getPosts(){
        useCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = ListState(posts = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    ListState(isLoading = true)
                }
                is Resource.Error -> {
                    ListState(error = "Xeta bas verdi")
                }

            }
        }.launchIn(viewModelScope)
    }
}