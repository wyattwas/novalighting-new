package de.novalighting.controller

import de.novalighting.dto.EquipmentDTO
import de.novalighting.dto.EquipmentRequestDTO
import de.novalighting.repository.EquipmentRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.patch
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.route

fun Route.equipmentRoutes(repository: EquipmentRepository) = route("/equipment") {
    get {
        call.respond(repository.getAll())
    }

    post {
        val equipmentDTO = call.receive< EquipmentRequestDTO>()

        try {
            val equipment = repository.add(equipmentDTO)
            call.respond(HttpStatusCode.OK, equipment)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.BadGateway, e)
        }
    }

    route("/{id}") {
        get {
            val id = call.parameters["id"]?.toIntOrNull() ?: throw IllegalArgumentException("Invalid ID")

            try {
                val equipment = repository.getById(id)
                call.respond(HttpStatusCode.OK, equipment)
            } catch (_: Exception) {
                call.respond(HttpStatusCode.NotFound)
            }
        }

        put {
            val equipment = call.receive<EquipmentDTO>()


        }

        patch {
            val id = call.parameters["id"]?.toIntOrNull() ?: throw IllegalArgumentException("Invalid ID")

        }

        delete {
            val id = call.parameters["id"]?.toIntOrNull() ?: throw IllegalArgumentException("Invalid ID")

        }
    }
}