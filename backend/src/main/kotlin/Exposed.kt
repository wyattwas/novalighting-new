package de.novalighting

import de.novalighting.model.CategoryTable
import de.novalighting.model.EquipmentTable
import io.ktor.server.application.Application
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction

suspend fun Application.configureExposed() {
    Database.connect(
        "jdbc:postgresql://localhost:5432/novalighting",
        user = "user",
        password = "password"
    )

    suspendTransaction {
        SchemaUtils.create(EquipmentTable, CategoryTable)
    }
}