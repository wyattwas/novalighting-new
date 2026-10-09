package de.novalighting.repository

import de.novalighting.dto.EquipmentDTO

interface EquipmentRepository {
    suspend fun getAll(): List<EquipmentDTO>
    suspend fun getById(id: Int): EquipmentDTO
    suspend fun add(equipment: EquipmentDTO): Int
    suspend fun update(id: Int, equipment: EquipmentDTO): EquipmentDTO
    suspend fun delete(id: Int): Boolean
}