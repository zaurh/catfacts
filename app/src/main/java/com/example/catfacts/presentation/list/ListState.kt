package com.example.catfacts.presentation.list

import com.example.catfacts.domain.model.Posts

data class ListState(
    val posts: List<Posts> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
