package de.novalighting.model

import kotlinx.serialization.Serializable

@Serializable
data class BookingFile(
    val id: Int,
    var booking: Booking,
    val originalFilename: String,
    var storedFilename: String,
    var contentType: String,
    var sizeBytes: Int,
    val uploadedAt: Long,
)
