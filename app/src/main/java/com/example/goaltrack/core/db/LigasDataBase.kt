package com.example.goaltrack.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.goaltrack.core.dao.UsuarioDao
import com.example.goaltrack.core.daos.LigaDao
import com.example.goaltrack.core.entities.LaLiga
import com.example.goaltrack.core.entities.PremierLeague
import com.example.goaltrack.core.entities.SerieA
import com.example.goaltrack.core.entities.Bundesliga
import com.example.goaltrack.core.entities.Eredivise
import com.example.goaltrack.core.entities.Ligue1
import com.example.goaltrack.core.entities.PrimeiraLiga
import com.example.goaltrack.core.entities.LigaMX

@Database(entities = [LaLiga::class, PremierLeague::class, SerieA::class, Bundesliga::class, Ligue1::class, PrimeiraLiga::class, Eredivise::class, LigaMX::class], version = 1)
abstract class LigasDataBase : RoomDatabase() {

    // DA0 = DAO (Data Access Object)
    abstract fun ligaDao(): LigaDao
}