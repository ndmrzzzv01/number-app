package com.example.numberapplication.network.api

import com.example.numberapplication.network.data.Fact
import retrofit2.http.GET
import retrofit2.http.Path

interface NumberApi {

    @GET("{number}?json")
    suspend fun getFactAboutNumber(
        @Path(value = "number", encoded = true) number: Int,
    ): Fact

    @GET("random/math/?json")
    suspend fun getFactAboutRandomNumber(): Fact

}