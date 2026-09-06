package de.novalighting.model

import org.jetbrains.exposed.v1.core.dao.id.IntIdTable

object CategoryTable : IntIdTable() {
    val name = text("name")
}
