package de.novalighting.model

sealed interface BookingItemType

data class EquipmentItem(
    val equipment: Equipment
) : BookingItemType

data class PackageItemType(
    val `package`: Package
) : BookingItemType