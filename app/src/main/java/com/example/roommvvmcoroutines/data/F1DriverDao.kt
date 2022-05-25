package com.example.roommvvmcoroutines.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface F1DriverDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg drivers: F1Driver)

    @Delete
    suspend fun delete(driver: F1Driver)

    @Query("SELECT * from f1_drivers")
    fun getAll(): LiveData<List<F1Driver>>
}