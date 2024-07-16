package com.example.banco_room.Banco

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao():UserDao
    companion object {
        private lateinit var INSTANCE: UserDatabase

        fun getDatabase(context: Context): UserDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(UserDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context, UserDatabase::class.java, "UserDB")
                        //.addMigrations(Migration_1)
                        .allowMainThreadQueries()
                        .build()

                }
            }
            return INSTANCE
        }

        private val Migration_1: Migration = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                //Teste
            }
        }

    }

}