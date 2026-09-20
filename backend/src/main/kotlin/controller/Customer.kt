package de.novalighting.controller

import de.novalighting.model.Customer
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.patch
import io.ktor.server.routing.put
import io.ktor.server.routing.route

private var customer = Customer(1, "Test", "Test", "Test", "+49182473467", "Test", "Test", 1)

fun Route.customer() {
    route("/customer") {
        get {
            return@get call.respond(customer)
        }

        route("/{id}") {
            get {
                val id = call.parameters["id"]?.toIntOrNull()
                    ?: call.respond(HttpStatusCode.BadRequest, "Missing or malformed id")
                call.respond(HttpStatusCode.OK, customer)
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
}