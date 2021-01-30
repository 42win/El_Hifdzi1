package com.az.elhifdzi.mvp.santri

import com.az.elhifdzi.model.santri.TaqdimulHistory

interface TaqdimulHistoryView {
    fun showLoading()
    fun hideLoading()
    fun onRespone(hasil: ArrayList<TaqdimulHistory>?)
    fun onError(message: String?)
}