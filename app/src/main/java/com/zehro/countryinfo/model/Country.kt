package com.zehro.countryinfo.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name") // field name in the return data
    val countryName: String?,

    @SerializedName("capital")
    val capital: String?,

    @SerializedName("flagPNG")
    val flag: String?
)
