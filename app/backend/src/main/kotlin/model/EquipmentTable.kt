package de.novalighting.model

import org.jetbrains.exposed.v1.core.ReferenceOption
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.datetime.CurrentDateTime
import org.jetbrains.exposed.v1.datetime.datetime

object EquipmentTable : IntIdTable("equipment") {
    val name = text("name")
    val category = reference("category_id", CategoryTable.id, onDelete = ReferenceOption.SET_NULL)
    val manufacturer = text("manufacturer").nullable()
    val powerWatts = integer("power_watts").nullable()
    val weightKg = double("weight_kg").nullable()
    val specs = text("specs").nullable()
    val totalQuantity = integer("total_quantity").default(1)
    val pricePerDay = double("price_per_day").default(0.0)
    val notes = text("notes").nullable()
    val active = bool("active").default(true)
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime)
}