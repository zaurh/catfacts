package com.example.catfacts.presentation.specific

import com.example.catfacts.domain.model.Specific

data class SpecificState(
    val specific: Specific? = null,
    val error: String = "",
    val isLoading: Boolean = false
)
