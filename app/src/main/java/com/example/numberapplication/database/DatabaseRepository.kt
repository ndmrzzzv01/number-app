package com.example.numberapplication.database

import com.example.numberapplication.database.data.FactEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DatabaseRepository {

    private val database = DatabaseInitializer.get()

    suspend fun getAllFacts(): MutableList<FactEntity>? = withContext(Dispatchers.IO) {
        database?.getAllFacts()
    }

    suspend fun getFact(id: Int): FactEntity? = withContext(Dispatchers.IO) {
        database?.getFact(id)
    }

    suspend fun insertFactToDatabase(fact: FactEntity): Long? = withContext(Dispatchers.IO) {
        database?.insertFactToDatabase(fact)
    }

}