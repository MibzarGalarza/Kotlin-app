package com.example.goaltrack.core.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LigaMX")
data class LigaMX(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // Identificador único autogenerado

    val club: String, // Nombre del equipo o club

    val pjPartidosJugados: Int, // Partidos Jugados
    val gTriunfos: Int,        // Triunfos (Ganados)
    val eEmpates: Int,         // Empates
    val pDerrotas: Int,        // Derrotas

    val gfGolesMarcados: Int,  // Goles a Favor
    val gcGolesEnContra: Int,  // Goles en Contra
    val dgDiferenciaGoles: Int, // Diferencia de Goles

    val ptsPuntos: Int,        // Puntos Obtenidos

    val ultimos5: String,      // Resultados de los Últimos 5 Partidos (Ej. "GGGEE")
    val serieFinal: String     // Estado en la Serie Final (Ej. "Serie final", "Eliminatorias de la serie final")
)
