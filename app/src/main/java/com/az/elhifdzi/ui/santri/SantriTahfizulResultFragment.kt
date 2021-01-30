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
import com.az.elhifdzi.adapter.santri.ListTahfizulResultAdapter
import com.az.elhifdzi.model.santri.TahfizulResult
import com.az.elhifdzi.mvp.santri.TahfizulResultPresenter
import com.az.elhifdzi.mvp.santri.TahfizulResultView
import kotlinx.android.synthetic.main.fragment_santri_tahfizul_result.view.*

class SantriTahfizulResultFragment : Fragment(), TahfizulResultView {

    private lateinit var mainPresenter: TahfizulResultPresenter
    private lateinit var adapter : ListTahfizulResultAdapter
    private var list: MutableList<TahfizulResult> = mutableListOf()

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainPresenter = TahfizulResultPresenter(this)
        progressBar()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_santri_tahfizul_result, container, false)
        loadResult(root)
        return root
    }

    private fun loadResult(v: View) {
        val url = resources.getString(R.string.url)
        var idUser = "1"
        mainPresenter.getResult(url,idUser)
        v.rvTahfizulResult.layoutManager = LinearLayoutManager(requireContext())
        adapter = ListTahfizulResultAdapter(list)
        v.rvTahfizulResult.setHasFixedSize(true)
        v.rvTahfizulResult.adapter = adapter
    }

    override fun showLoading() {
        progressDialog!!.show()
    }

    override fun hideLoading() {
        progressDialog!!.hide()
    }

    override fun onRespone(hasil: ArrayList<TahfizulResult>?) {
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