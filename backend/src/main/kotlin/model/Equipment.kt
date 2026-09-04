package de.novalighting.model

import kotlinx.serialization.Serializable

@Serializable
data class Equipment(
    val id: Int,
    var name: String,
    var category: String,
    val manufacturer: String,
    var powerWatts: Double,
    var weightKg: Double,
    var specs: String,
    var totalQuantity: Int,
    var pricePerDay: Double
)