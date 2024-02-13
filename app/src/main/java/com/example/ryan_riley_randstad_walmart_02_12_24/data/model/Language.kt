package com.example.ryan_riley_randstad_walmart_02_12_24.data.model

import com.google.gson.annotations.SerializedName

data class Language(
    @SerializedName("code")
    val code: String,
    @SerializedName("iso639_2")
    val iso6392: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nativeName")
    val nativeName: String
)
