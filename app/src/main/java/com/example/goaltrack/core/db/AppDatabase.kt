package com.example.goaltrack.db


import android.content.Context


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.goaltrack.core.dao.UsuarioDao
import com.example.goaltrack.core.entities.Usuario

@Database(entities = [Usuario::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "usersliga.db"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
