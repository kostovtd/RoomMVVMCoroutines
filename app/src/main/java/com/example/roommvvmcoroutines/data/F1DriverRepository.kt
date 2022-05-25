package com.example.roommvvmcoroutines.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class F1DriverRepository @Inject internal constructor(private val f1DriverDao: F1DriverDao) {

    suspend fun addNewF1Driver(
        firstName: String?,
        lastName: String?,
        team: String?,
        age: Int?,
        numberOfPodiums: Int?
    ): Resource<Any> {
        when {
            firstName.isNullOrBlank() -> {
                return Resource(ResourceStatus.ERROR, error = ErrorType.EMPTY_FIRST_NAME)
            }
            firstName.contains(Regex("\\d")) -> {
                return Resource(ResourceStatus.ERROR, error = ErrorType.INVALID_FORMAT_FIRST_NAME)
            }
            else -> {
                // For simplicity - no checks for the other fields.
                f1DriverDao.insertAll(
                    F1Driver(
                        firstName, lastName ?: "", age ?: 18,
                        team ?: "", numberOfPodiums ?: 0
                    )
                )
                return Resource(ResourceStatus.SUCCESS)
            }
        }
    }

    suspend fun removeF1Driver(f1Driver: F1Driver) = f1DriverDao.delete(f1Driver)

    fun getAllF1Drivers() = f1DriverDao.getAll()
}