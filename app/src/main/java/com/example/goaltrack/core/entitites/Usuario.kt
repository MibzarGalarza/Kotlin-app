package com.example.goaltrack.core.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usersliga")  // Asegúrate de que el nombre de la tabla sea 'users'
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val correo: String,
    val contrasena: String
)
