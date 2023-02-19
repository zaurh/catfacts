package com.example.catfacts.presentation.specific

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catfacts.common.Resource
import com.example.catfacts.domain.model.Specific
import com.example.catfacts.domain.use_case.GetSpecificUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SpecificViewModel @Inject constructor(
    private val getSpecificUseCase: GetSpecificUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(SpecificState())
        val state: State<SpecificState> = _state

    init {
        savedStateHandle.get<String>("id")?.let { id ->
            getSpecific(id)
        }
    }
    private fun getSpecific(id: String){
        getSpecificUseCase(id).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = SpecificState(specific = result.data)
                }
                is Resource.Loading -> {
                    SpecificState(isLoading = true)
                }
                is Resource.Error -> {
                    SpecificState(error = "Ötürmədə səhvlik oldu")
                }

            }
        }.launchIn(viewModelScope)
    }
}