package com.az.elhifdzi.ui.santri

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.az.elhifdzi.R
import com.az.elhifdzi.adapter.santri.ListTahfizulSurahAdapter
import com.az.elhifdzi.adapter.santri.ListTaqdimulSurahAdapter
import com.az.elhifdzi.common.Common
import com.az.elhifdzi.model.santri.TahfizulSurah
import com.az.elhifdzi.mvp.santri.TahfizulSurahPresenter
import com.az.elhifdzi.mvp.santri.TaqdimulSurahPresenter
import com.az.elhifdzi.mvp.santri.TaqdimulSurahView
import kotlinx.android.synthetic.main.fragment_santri_tahfizul_surah.view.*

class SantriTaqdimulSurahFragment : Fragment(),TaqdimulSurahView {

    private lateinit var mainPresenter: TaqdimulSurahPresenter
    private lateinit var adapter : ListTaqdimulSurahAdapter
    private var list: MutableList<TahfizulSurah> = mutableListOf()

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainPresenter = TaqdimulSurahPresenter(this)
        progressBar()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_santri_taqdimul_surah, container, false)
        loadSurah(root)
        return root
    }

    private fun loadSurah(v: View) {
        val url = resources.getString(R.string.url)
        mainPresenter.getSurah(url)
        v.rvSurah.layoutManager = LinearLayoutManager(requireContext())
        adapter = ListTaqdimulSurahAdapter(list)
        v.rvSurah.setHasFixedSize(true)
        v.rvSurah.adapter = adapter

        adapter.setOnItemClickCallback(object : ListTaqdimulSurahAdapter.OnItemClickCallback{
            override fun onItemClicked(data: TahfizulSurah) {
                var model = TahfizulSurah(
                    data.idSurah,
                    data.namaSurah,
                    data.jumlahAyat
                )
                Common.surahSelected = model
                findNavController().navigate(R.id.action_santriTaqdimulFragment_to_santriTaqdimulMulaiFragment2)
            }

        })
    }

    override fun showLoading() {
        progressDialog!!.show()
    }

    override fun hideLoading() {
        progressDialog!!.hide()
    }

    override fun onRespone(hasil: ArrayList<TahfizulSurah>?) {
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