package me.projekt401.projkt.models

import com.google.gson.annotations.SerializedName

data class Questions (

    @SerializedName("id") val id : String,
    @SerializedName("text") val text : String,
    @SerializedName("type") val type : String,
    @SerializedName("required") val required : Boolean,
    @SerializedName("options") val options : List<Options>
)