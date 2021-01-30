package com.az.elhifdzi.ui.santri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.az.elhifdzi.R
import com.az.elhifdzi.common.Common
import kotlinx.android.synthetic.main.fragment_santri_tahfizul_mulai.view.*

class SantriTahfizulMulaiFragment : Fragment(),View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root= inflater.inflate(R.layout.fragment_santri_tahfizul_mulai, container, false)
        root.Btnujicoba.setOnClickListener(this)
        (activity as AppCompatActivity).supportActionBar?.title= Common.surahSelected?.namaSurah
        return root
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.Btnujicoba->{
                findNavController().navigate(R.id.action_santriTahfizulFragment_to_santriTahfizulBaseFragment)
            }
        }
    }


}