package de.novalighting.repository

import de.novalighting.dao.CategoryDAO
import de.novalighting.dto.EquipmentDTO
import de.novalighting.dao.EquipmentDAO
import de.novalighting.dao.daoToDto
import de.novalighting.dao.withTransaction
import de.novalighting.model.EquipmentTable
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.deleteWhere

class ExposedEquipmentRepository : EquipmentRepository {
    override suspend fun getAll(): List<EquipmentDTO> = withTransaction {
        EquipmentDAO.all().map(::daoToDto)
    }

    override suspend fun getById(id: Int): EquipmentDTO = withTransaction {
        EquipmentDAO.findById(id)?.let { daoToDto(it) } ?: throw Exception("Record not found")
    }

    override suspend fun add(equipment: EquipmentDTO) = withTransaction {
        val category = CategoryDAO.findById(equipment.category.id) ?: throw Exception("No Category record found")
        val equipment = EquipmentDAO.new {
            this.name = equipment.name
            this.category = category
            this.manufacturer = equipment.manufacturer
            this.powerWatts = equipment.powerWatts
            this.weightKg = equipment.weightKg
            this.specs = equipment.specs
            this.totalQuantity = equipment.totalQuantity
            this.pricePerDay = equipment.pricePerDay
            this.notes = equipment.notes
            this.active = equipment.active
            this.createdAt = LocalDateTime.parse(equipment.createdAt.toString())
        }
        equipment.id.value
    }

    override suspend fun update(id: Int, equipment: EquipmentDTO): EquipmentDTO = withTransaction {
        val equipmentDao = EquipmentDAO.findById(id) ?: throw Exception("Record not found")
        val category = CategoryDAO.findById(equipmentDao.category.id) ?: throw Exception("No Category record found")

        equipmentDao.name = equipment.name
        equipmentDao.category = category
        equipmentDao.manufacturer = equipment.manufacturer
        equipmentDao.powerWatts = equipment.powerWatts
        equipmentDao.weightKg = equipment.weightKg
        equipmentDao.specs = equipment.specs
        equipmentDao.totalQuantity = equipment.totalQuantity
        equipmentDao.pricePerDay = equipment.pricePerDay
        equipmentDao.notes = equipment.notes
        equipmentDao.active = equipment.active

        daoToDto(equipmentDao)
    }

    override suspend fun delete(id: Int): Boolean = withTransaction {
        val rowsDeleted = EquipmentTable.deleteWhere {
            EquipmentTable.id eq id
        }
        rowsDeleted == 1
    }
}