package com.az.elhifdzi.mvp.santri

import com.az.elhifdzi.model.santri.TahfizulResult
import com.az.elhifdzi.model.santri.TahfizulSurah

interface TahfizulResultView {
    fun showLoading()
    fun hideLoading()
    fun onRespone(hasil: ArrayList<TahfizulResult>?)
    fun onError(message: String?)
}