package com.example.roommvvmcoroutines.data

import androidx.room.Entity

@Entity(
    tableName = "f1_drivers",
    primaryKeys = ["firstName", "lastName"]
)
class F1Driver(
    firstName: String,
    lastName: String,
    age: Int,
    val team: String,
    val podiums: Int
) : Person(firstName, lastName, age)