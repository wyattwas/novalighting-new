package de.novalighting.model

import kotlinx.serialization.Serializable

@Serializable
data class Booking(
    val id: Int,
    var name: String,
    var customer: Customer,
    var eventName: String,
    var location: String?,
    var startDate: Long,
    var endDate: Long,
    var status: Status,
    var notes: String?,
    val createdAt: Long,
)
