package de.novalighting.dao

import de.novalighting.dto.CategoryDTO
import de.novalighting.dto.EquipmentDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import org.jetbrains.exposed.v1.jdbc.JdbcTransaction
import org.jetbrains.exposed.v1.jdbc.transactions.inTopLevelSuspendTransaction

suspend fun <T> withTransaction(block: suspend JdbcTransaction.() -> T): T = withContext(Dispatchers.IO) {
    inTopLevelSuspendTransaction { block() }
}

fun daoToDto(dao: EquipmentDAO) = EquipmentDTO(
    dao.id.value,
    dao.name,
    daoToDto(dao.category),
    dao.manufacturer,
    dao.powerWatts,
    dao.weightKg,
    dao.specs,
    dao.totalQuantity,
    dao.pricePerDay,
    dao.notes,
    dao.active,
    dao.createdAt.toInstant(TimeZone.UTC),
)

fun daoToDto(dao: CategoryDAO) = CategoryDTO(
    dao.id.value,
    dao.name,
)