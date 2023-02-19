package com.example.catfacts.data.remote.dto

import com.example.catfacts.domain.model.Specific

data class SpecificDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun SpecificDto.toSpecific(): Specific {
    return Specific(body, id, title, userId)
}