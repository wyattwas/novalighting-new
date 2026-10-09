package de.novalighting.dto

import kotlinx.serialization.Serializable

@Serializable
data class CategoryDTO(
    val id: Int,
    val name: String,
)