package com.example.fitness_app.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val calories: String,
    val variant: String,
    val ingredients: String,
    val amount: String
)
