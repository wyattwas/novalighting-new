package de.novalighting.dto

import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class EquipmentDTO(
    val id: Int,
    var name: String,
    var category: CategoryDTO,
    var manufacturer: String?,
    var powerWatts: Int?,
    var weightKg: Double?,
    var specs: String?,
    var totalQuantity: Int,
    var pricePerDay: Double,
    var notes: String?,
    var active: Boolean,
    val createdAt: Instant,
)