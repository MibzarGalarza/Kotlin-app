package com.example.goaltrack.core.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.goaltrack.core.entities.Usuario


@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usersliga")
    fun obtenerTodos(): List<Usuario>

    @Query("SELECT * FROM usersliga WHERE correo = :correo")
    fun obtenerPorId(correo: String): Usuario?

    @Insert
    suspend fun insertar(usuario: Usuario)

    @Update
    suspend fun actualizar(usuario: Usuario)

    @Delete
    suspend fun eliminar(usuario: Usuario)
}
