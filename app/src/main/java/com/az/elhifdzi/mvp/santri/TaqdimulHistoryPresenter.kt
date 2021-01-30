package com.az.elhifdzi.mvp.santri

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.az.elhifdzi.model.santri.TahfizulSurahResponse
import com.az.elhifdzi.model.santri.TaqdimulHistoryResponse

class TaqdimulHistoryPresenter(private val mainView: TaqdimulHistoryView)  {
    fun getHistory(url: String, idUser: String) {

        mainView.showLoading()

        AndroidNetworking.post("$url/api/Santri/taqdimulHistory")
            .addBodyParameter("idUser",idUser)
            .setTag("hasil")
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(TaqdimulHistoryResponse::class.java, object :
                ParsedRequestListener<TaqdimulHistoryResponse> {
                override fun onResponse(response: TaqdimulHistoryResponse?) {
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