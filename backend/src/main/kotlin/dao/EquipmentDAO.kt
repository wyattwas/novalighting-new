package de.novalighting.dao

import de.novalighting.model.EquipmentTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

class EquipmentDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<EquipmentDAO>(EquipmentTable)

    var name by EquipmentTable.name
    var category by CategoryDAO referencedOn EquipmentTable.category
    var manufacturer by EquipmentTable.manufacturer
    var powerWatts by EquipmentTable.powerWatts
    var weightKg by EquipmentTable.weightKg
    var specs by EquipmentTable.specs
    var totalQuantity by EquipmentTable.totalQuantity
    var pricePerDay by EquipmentTable.pricePerDay
    var notes by EquipmentTable.notes
    var active by EquipmentTable.active
    var createdAt by EquipmentTable.createdAt
}