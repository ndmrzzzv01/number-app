package com.example.numberapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.numberapplication.database.dao.FactsDao
import com.example.numberapplication.database.data.FactEntity

@Database(entities = [FactEntity::class], version = 1)
abstract class FactsDatabase : RoomDatabase() {
    abstract fun factsDao(): FactsDao
}