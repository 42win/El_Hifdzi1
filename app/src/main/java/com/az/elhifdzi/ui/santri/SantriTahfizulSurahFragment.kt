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
import com.az.elhifdzi.common.Common
import com.az.elhifdzi.model.santri.TahfizulSurah
import com.az.elhifdzi.mvp.santri.TahfizulSurahPresenter
import com.az.elhifdzi.mvp.santri.TahfizulSurahView
import kotlinx.android.synthetic.main.fragment_santri_tahfizul_surah.view.*

class SantriTahfizulSurahFragment : Fragment(),TahfizulSurahView {

    private lateinit var mainPresenter: TahfizulSurahPresenter
    private lateinit var adapter : ListTahfizulSurahAdapter
    private var list: MutableList<TahfizulSurah> = mutableListOf()

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainPresenter = TahfizulSurahPresenter(this)
        progressBar()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_santri_tahfizul_surah, container, false)
        loadSurah(root)
        return root
    }

    private fun loadSurah(v: View) {
        val url = resources.getString(R.string.url)
        mainPresenter.getSurah(url)
        v.rvSurah.layoutManager = LinearLayoutManager(requireContext())
        adapter = ListTahfizulSurahAdapter(list)
        v.rvSurah.setHasFixedSize(true)
        v.rvSurah.adapter = adapter

        adapter.setOnItemClickCallback(object : ListTahfizulSurahAdapter.OnItemClickCallback{
            override fun onItemClicked(data: TahfizulSurah) {
                var model = TahfizulSurah(
                    data.idSurah,
                    data.namaSurah,
                    data.jumlahAyat
                )
                Common.surahSelected = model
                findNavController().navigate(R.id.action_santriTahfizulSurahFragment_to_santriTahfizulFragment)
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