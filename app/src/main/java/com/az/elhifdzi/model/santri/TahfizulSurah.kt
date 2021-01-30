package com.az.elhifdzi.model.santri

import com.google.gson.annotations.SerializedName

data class TahfizulSurah (
    @SerializedName("id_surah")
    val idSurah: Int?=null,

    @SerializedName("surah")
    val namaSurah: String?=null,

    @SerializedName("jumlah_ayat")
    val jumlahAyat: Int?=null
)