package com.example.numberapplication

import android.app.Application
import com.example.numberapplication.database.DatabaseInitializer
import com.example.numberapplication.network.RetrofitInitializer

class NumberApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitInitializer.init()
        DatabaseInitializer.init(this)
    }

}