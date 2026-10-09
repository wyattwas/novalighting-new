package de.novalighting.controller

import de.novalighting.repository.EquipmentRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.patch
import io.ktor.server.routing.put
import io.ktor.server.routing.route

fun Route.equipmentRoutes(repository: EquipmentRepository) = route("/equipment") {
    get {
        return@get call.respond(repository.getAll())
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
            val id = call.parameters["id"]?.toIntOrNull()
                ?: call.respond(HttpStatusCode.BadRequest, "Missing or malformed id")

        }

        patch {
            val id = call.parameters["id"]?.toIntOrNull()
                ?: call.respond(HttpStatusCode.BadRequest, "Missing or malformed id")

        }

        delete {
            val id = call.parameters["id"]?.toIntOrNull()
                ?: call.respond(HttpStatusCode.BadRequest, "Missing or malformed id")

        }
    }
}