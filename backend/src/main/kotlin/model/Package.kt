package de.novalighting.model

import kotlinx.serialization.Serializable

@Serializable
data class Package(
    val id: Int,
    var name: String,
    var notes: String?,
    var pricePerDay: Double?,
    var active: Boolean,
    val createdAt: Long,
)
