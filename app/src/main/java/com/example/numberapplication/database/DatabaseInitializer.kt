package com.example.numberapplication.database

import android.content.Context
import androidx.room.Room
import com.example.numberapplication.database.dao.FactsDao

class DatabaseInitializer {

    companion object {
        private const val DATABASE_NAME = "database"
        private var instance: FactsDatabase? = null

        fun init(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    FactsDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
        }

        fun get(): FactsDao? {
            return instance?.factsDao()
        }
    }
}