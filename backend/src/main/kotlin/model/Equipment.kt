package de.novalighting.model

import kotlinx.serialization.Serializable

@Serializable
data class Equipment(
    val id: Int,
    var name: String,
    var category: Category,
    var manufacturer: String?,
    var powerWatts: Int,
    var weightKg: Double,
    var specs: String?,
    var totalQuantity: Int,
    var pricePerDay: Double,
    var notes: String?,
    var active: Boolean,
    val createdAt: Long,
)