package com.az.elhifdzi.mvp.santri

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.az.elhifdzi.model.santri.TahfizulResult
import com.az.elhifdzi.model.santri.TahfizulResultResponse
import com.az.elhifdzi.model.santri.TahfizulSurahResponse

class TahfizulResultPresenter(private val mainView: TahfizulResultView)  {
    fun getResult(url: String, idUser: String) {

        mainView.showLoading()

        AndroidNetworking.post("$url/api/Santri/tahfizulResult")
            .addBodyParameter("idUser",idUser)
            .setTag("hasil")
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(TahfizulResultResponse::class.java, object :
                ParsedRequestListener<TahfizulResultResponse> {
                override fun onResponse(response: TahfizulResultResponse?) {
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