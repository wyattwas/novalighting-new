package de.novalighting

import de.novalighting.repository.EquipmentRepository
import de.novalighting.repository.ExposedEquipmentRepository
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureDependencies() {
    install(Koin) {
        modules(
            module {
                single<EquipmentRepository> {
                    ExposedEquipmentRepository()
                }
            }
        )
    }
}