package de.novalighting.repository

import de.novalighting.model.Booking

interface BookingRepository {
    suspend fun getAll(): List<Booking>
    suspend fun getById(id: Long): Booking?
    suspend fun add(booking: Booking)
    suspend fun update(booking: Booking)
    suspend fun delete(id: Long)
}