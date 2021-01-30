package com.az.elhifdzi.model.santri
import com.google.gson.annotations.SerializedName

data class TahfizulResult (
    @SerializedName("id_surat")
    val idSurah: Int?=null,

    @SerializedName("nomor_ayat")
    val nomorAyat: Int?=null,

    @SerializedName("ayat")
    val ayat: String?=null,

    @SerializedName("evaluation")
    val evaluation: Int?=null
)