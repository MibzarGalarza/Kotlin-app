package com.example.goaltrack.core.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.goaltrack.core.entities.LaLiga
import com.example.goaltrack.core.entities.PremierLeague
import com.example.goaltrack.core.entities.SerieA
import com.example.goaltrack.core.entities.Bundesliga
import com.example.goaltrack.core.entities.Eredivise
import com.example.goaltrack.core.entities.Ligue1
import com.example.goaltrack.core.entities.PrimeiraLiga
import com.example.goaltrack.core.entities.LigaMX


@Dao
interface LigaDao {
    // Consultas para LaLiga
    @Query("SELECT * FROM LaLiga")
    fun getAllLaLiga(): List<LaLiga>

    @Query("SELECT * FROM LaLiga WHERE id = :id")
    fun getLaLigaById(id: Int): LaLiga

    @Query("SELECT * FROM LaLiga WHERE club = :club")
    fun getLaLigaByClub(club: String): LaLiga

    // Consultas para PremierLeague
    @Query("SELECT * FROM PremierLeague")
    fun getAllPremierLeague(): List<PremierLeague>

    @Query("SELECT * FROM PremierLeague WHERE id = :id")
    fun getPremierLeagueById(id: Int): PremierLeague

    @Query("SELECT * FROM PremierLeague WHERE club = :club")
    fun getPremierLeagueByClub(club: String): PremierLeague

    // Consultas para SerieA
    @Query("SELECT * FROM SerieA")
    fun getAllSerieA(): List<SerieA>

    @Query("SELECT * FROM SerieA WHERE id = :id")
    fun getSerieAById(id: Int): SerieA

    @Query("SELECT * FROM SerieA WHERE club = :club")
    fun getSerieAByClub(club: String): SerieA

    // Consultas para Bundesliga
    @Query("SELECT * FROM Bundesliga")
    fun getAllBundesliga(): List<Bundesliga>

    @Query("SELECT * FROM Bundesliga WHERE id = :id")
    fun getBundesligaById(id: Int): Bundesliga

    @Query("SELECT * FROM Bundesliga WHERE club = :club")
    fun getBundesligaByClub(club: String): Bundesliga

    // Consultas para Ligue1
    @Query("SELECT * FROM Ligue1")
    fun getAllLigue1(): List<Ligue1>

    @Query("SELECT * FROM Ligue1 WHERE id = :id")
    fun getLigue1ById(id: Int): Ligue1

    @Query("SELECT * FROM Ligue1 WHERE club = :club")
    fun getLigue1ByClub(club: String): Ligue1

    // Consultas para PrimeiraLiga
    @Query("SELECT * FROM PrimeiraLiga")
    fun getAllPrimeiraLiga(): List<PrimeiraLiga>

    @Query("SELECT * FROM PrimeiraLiga WHERE id = :id")
    fun getPrimeiraLigaById(id: Int): PrimeiraLiga

    @Query("SELECT * FROM PrimeiraLiga WHERE club = :club")
    fun getPrimeiraLigaByClub(club: String): PrimeiraLiga

    // Consultas para Eredivisie
    @Query("SELECT * FROM Eredivise")
    fun getAllEredivisie(): List<Eredivise>

    @Query("SELECT * FROM Eredivise WHERE id = :id")
    fun getEredivisieById(id: Int): Eredivise

    @Query("SELECT * FROM Eredivise WHERE club = :club")
    fun getEredivisieByClub(club: String): Eredivise

    // Consultas para LigaMx
    @Query("SELECT * FROM LigaMx")
    fun getAllLigaMx(): List<LigaMX>

    @Query("SELECT * FROM LigaMx WHERE id = :id")
    fun getLigaMxById(id: Int): LigaMX

    @Query("SELECT * FROM LigaMx WHERE club = :club")
    fun getLigaMxByClub(club: String): LigaMX
}
