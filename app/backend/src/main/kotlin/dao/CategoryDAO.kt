package de.novalighting.dao

import de.novalighting.model.CategoryTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

class CategoryDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CategoryDAO>(CategoryTable)

    var name by CategoryTable.name
}