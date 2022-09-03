package com.example.numberapplication.network

import com.example.numberapplication.network.api.NumberApi
import com.example.numberapplication.network.data.Fact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NumberRepository {

    private val retrofit = RetrofitInitializer.get()

    suspend fun getFactAboutNumber(number: Int): Fact = withContext(Dispatchers.IO) {
        retrofit.create(NumberApi::class.java).getFactAboutNumber(number)
    }

    suspend fun getFactAboutRandomNumber(): Fact = withContext(Dispatchers.IO) {
        retrofit.create(NumberApi::class.java).getFactAboutRandomNumber()
    }

}