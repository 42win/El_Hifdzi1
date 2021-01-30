package com.az.elhifdzi.ui.santri

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.az.elhifdzi.R
import com.az.elhifdzi.adapter.santri.ListTaqdimulHistoryAdapter
import com.az.elhifdzi.common.Common
import com.az.elhifdzi.model.santri.TaqdimulHistory
import com.az.elhifdzi.mvp.santri.TaqdimulHistoryPresenter
import com.az.elhifdzi.mvp.santri.TaqdimulHistoryView
import kotlinx.android.synthetic.main.fragment_santri_taqdimul_history.view.*

class SantriTaqdimulHistoryFragment : Fragment(),TaqdimulHistoryView {

    private lateinit var mainPresenter: TaqdimulHistoryPresenter
    private lateinit var adapter : ListTaqdimulHistoryAdapter
    private var list: MutableList<TaqdimulHistory> = mutableListOf()

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainPresenter = TaqdimulHistoryPresenter(this)
        progressBar()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_santri_taqdimul_history, container, false)
        loadHistory(root)
        return root
    }

    private fun loadHistory(v: View) {
        val url = resources.getString(R.string.url)
        var idUser = "1"
        mainPresenter.getHistory(url,idUser)
        v.rvHistoryTaqdimul.layoutManager = LinearLayoutManager(requireContext())
        adapter = ListTaqdimulHistoryAdapter(list)
        v.rvHistoryTaqdimul.setHasFixedSize(true)
        v.rvHistoryTaqdimul.adapter = adapter

        adapter.setOnItemClickCallback(object : ListTaqdimulHistoryAdapter.OnItemClickCallback{
            override fun onItemClicked(data: TaqdimulHistory) {
                var model = TaqdimulHistory(
                    data.idSurah,
                    data.namaSurah,
                    data.stsUstadz
                )
                Common.taqdimulHistorySelected = model
//                findNavController().navigate(R.id.)
            }

        })
    }

    override fun showLoading() {
        progressDialog!!.show()
        println("loading")
    }

    override fun hideLoading() {
        progressDialog!!.hide()
    }

    override fun onRespone(hasil: ArrayList<TaqdimulHistory>?) {
        println(hasil)
        list.clear()
        hasil?.let{
            list.addAll(it)
        }
        adapter.notifyDataSetChanged()
    }

    override fun onError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        Log.d("onError", message!!)
    }

    private fun progressBar(){
        progressDialog = ProgressDialog(requireContext())
        progressDialog!!.setTitle("Mohon Tunggu")
        progressDialog!!.setCancelable(false)
        progressDialog!!.setMessage("Sedang menampilkan data...")
    }

}