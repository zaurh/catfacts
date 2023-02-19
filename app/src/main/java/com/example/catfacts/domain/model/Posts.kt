package com.example.catfacts.domain.model


data class Posts(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)