package com.az.elhifdzi.model.santri
import com.google.gson.annotations.SerializedName

data class TahfizulResultResponse (
    @SerializedName("status")
    val status: String? = null,

    @SerializedName("hasil")
    val hasil: ArrayList<TahfizulResult>?
)