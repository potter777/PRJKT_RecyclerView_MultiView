package me.projekt401.projkt.models

import com.google.gson.annotations.SerializedName

data class Options(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("text")
    val text: String? = ""
)