package com.example.numberapplication.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.numberapplication.database.data.FactEntity
import com.example.numberapplication.network.data.Fact
import java.nio.LongBuffer

@Dao
interface FactsDao {

    @Query("SELECT * FROM facts ORDER BY id DESC")
    suspend fun getAllFacts(): MutableList<FactEntity>?

    @Query("SELECT * FROM facts WHERE id=(:id)")
    suspend fun getFact(id: Int): FactEntity?

    @Insert
    suspend fun insertFactToDatabase(fact: FactEntity): Long

}