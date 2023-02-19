package com.example.catfacts.data.remote.dto

import com.example.catfacts.domain.model.Posts

data class PostsDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PostsDto.toPosts(): Posts {
    return Posts(body, id, title, userId)
}