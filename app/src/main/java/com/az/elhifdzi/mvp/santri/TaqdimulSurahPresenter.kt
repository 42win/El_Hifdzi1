package com.az.elhifdzi.mvp.santri

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.az.elhifdzi.model.santri.TahfizulSurahResponse

class TaqdimulSurahPresenter(private val mainView: TaqdimulSurahView)  {
    fun getSurah(url: String) {

        mainView.showLoading()

        AndroidNetworking.get("$url/api/Santri/surahAll")
            .setTag("hasil")
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(TahfizulSurahResponse::class.java, object :
                ParsedRequestListener<TahfizulSurahResponse> {
                override fun onResponse(response: TahfizulSurahResponse?) {
                    mainView.onRespone(response?.hasil)
                    mainView.hideLoading()
                }
                override fun onError(anError: ANError?) {
                    mainView.onError(anError?.message.toString())
                    mainView.hideLoading()
                }
            })
    }

}