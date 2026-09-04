package de.novalighting.equipment

import de.novalighting.model.Equipment
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.patch
import io.ktor.server.routing.put
import io.ktor.server.routing.route

private var equipment: Equipment = Equipment(1, "Test", "Test", "Test", 50.0, 50.0, "Test", 1, 100.0)

fun Route.task() {
    route("/api/equipment") {
        get {
            return@get call.respond(equipment)
        }

        route("/{id}") {
            get {
                val id = call.pathParameters["id"]?.toInt() ?: return@get call.respond(HttpStatusCode.BadRequest)
                call.respond(HttpStatusCode.OK, equipment)
            }

            put {
                val id = call.pathParameters["id"]?.toInt() ?: return@put call.respond(HttpStatusCode.BadRequest)

            }

            patch {
                val id = call.pathParameters["id"]?.toInt() ?: return@patch call.respond(HttpStatusCode.BadRequest)

            }

            delete {
                val id = call.pathParameters["id"]?.toInt() ?: return@delete call.respond(HttpStatusCode.BadRequest)

            }
        }
    }
}