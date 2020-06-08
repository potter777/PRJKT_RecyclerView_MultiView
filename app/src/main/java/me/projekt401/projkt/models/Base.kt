package me.projekt401.projkt.models

import com.google.gson.annotations.SerializedName

data class Base(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("order")
    val order: String? = "",
    @SerializedName("questions")
    var questions: List<Questions> = arrayListOf())