package com.example.roommvvmcoroutines.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [F1Driver::class], version = 1, exportSchema = false)
abstract class F1Database : RoomDatabase() {

    abstract fun f1DriverDao(): F1DriverDao

    companion object {
        @Volatile
        private var instance: F1Database? = null

        fun getInstance(context: Context): F1Database {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context, F1Database::class.java, "f1_database").build().also {
                    instance = it
                }
            }
        }
    }
}