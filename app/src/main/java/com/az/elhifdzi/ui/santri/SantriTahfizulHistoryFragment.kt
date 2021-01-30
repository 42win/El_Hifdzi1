
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
import com.az.elhifdzi.adapter.santri.ListTahfizulResultAdapter
import com.az.elhifdzi.adapter.santri.ListTahfizulSurahAdapter
import com.az.elhifdzi.common.Common
import com.az.elhifdzi.model.santri.TahfizulResult
import com.az.elhifdzi.model.santri.TahfizulResultResponse
import com.az.elhifdzi.model.santri.TahfizulSurah
import com.az.elhifdzi.mvp.santri.TahfizulResultPresenter
import com.az.elhifdzi.mvp.santri.TahfizulResultView
import com.az.elhifdzi.mvp.santri.TahfizulSurahPresenter
import kotlinx.android.synthetic.main.fragment_santri_tahfizul_result.view.*
import kotlinx.android.synthetic.main.fragment_santri_tahfizul_surah.view.*

class SantriTahfizulHistoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_santri_tahfizul_history, container, false)
        return root
    }
}