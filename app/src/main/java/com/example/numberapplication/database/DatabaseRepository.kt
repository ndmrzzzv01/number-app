package com.example.numberapplication.database

import com.example.numberapplication.database.data.FactEntity

class DatabaseRepository {

    private val database = DatabaseInitializer.get()

    suspend fun getAllFacts(): MutableList<FactEntity>? = database?.getAllFacts()

    suspend fun getFact(id: Int): FactEntity? = database?.getFact(id)

    suspend fun insertFactToDatabase(fact: FactEntity) {
        database?.insertFactToDatabase(fact)
    }

}