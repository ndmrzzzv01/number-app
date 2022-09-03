package com.example.numberapplication.network.data

import com.google.gson.annotations.SerializedName

data class Fact(
    @SerializedName("text") val info: String? = "",
    val number: String? = "",
)
