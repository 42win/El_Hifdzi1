package com.az.elhifdzi.mvp.santri

import com.az.elhifdzi.model.santri.TahfizulSurah

interface TahfizulSurahView {
    fun showLoading()
    fun hideLoading()
    fun onRespone(hasil: ArrayList<TahfizulSurah>?)
    fun onError(message: String?)
}