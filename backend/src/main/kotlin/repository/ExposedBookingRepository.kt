package de.novalighting.repository

//import de.novalighting.entity.withTransaction
import de.novalighting.model.Booking

class ExposedBookingRepository: BookingRepository {
    override suspend fun getAll(): List<Booking> {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Long): Booking? {
        TODO("Not yet implemented")
    }

    override suspend fun add(booking: Booking) {
        TODO("Not yet implemented")
    }

    override suspend fun update(booking: Booking) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}