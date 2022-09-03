package com.example.numberapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    companion object {
        private const val URL = "http://numbersapi.com/"
        private var instance: Retrofit? = null

        fun init() {
            if (instance == null) {
                instance =
                    Retrofit
                        .Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
        }

        fun get(): Retrofit {
            return instance!!
        }

    }
}