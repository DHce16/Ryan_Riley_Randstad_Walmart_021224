package com.example.ryan_riley_randstad_walmart_02_12_24.data.model

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)