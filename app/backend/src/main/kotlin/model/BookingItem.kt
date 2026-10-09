package de.novalighting.model

import kotlinx.serialization.Serializable

@Serializable
data class BookingItem(
    val id: Int,
    var booking: Booking,
    var quantity: Int,
    var item: BookingItemType,
    var pricePerDay: Double,
)
