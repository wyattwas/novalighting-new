package de.novalighting.model

import kotlinx.serialization.Serializable

@Serializable
data class Customer(
    val id: Int,
    var name: String,
    var company: String?,
    var email: String?,
    var phone: String?,
    var address: String?,
    var notes: String?,
    val createdAt: Long,
)
