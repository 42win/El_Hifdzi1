package com.az.elhifdzi.model.santri
import com.google.gson.annotations.SerializedName

data class TaqdimulHistory (
    @SerializedName("id_history_taqdimul")
    val idSurah: Int?=null,

    @SerializedName("surah")
    val namaSurah: String?=null,

    @SerializedName("sts_ustadz")
    val stsUstadz: Int?=null,

    @SerializedName("date")
    val date: String?=null
)