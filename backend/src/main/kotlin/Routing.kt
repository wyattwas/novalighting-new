package de.novalighting

import de.novalighting.controller.customer
import de.novalighting.controller.equipmentRoutes
import de.novalighting.repository.EquipmentRepository
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val equipmentRepository by inject<EquipmentRepository>()

    routing {
        route("/api") {
            equipmentRoutes(equipmentRepository)
            customer()
//            categoryRoutes()
        }
    }
}