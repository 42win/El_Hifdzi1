package com.az.elhifdzi.ui.guru

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.az.elhifdzi.R
import kotlinx.android.synthetic.main.fragment_guru_kelas.view.*

class GuruKelasFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_guru_kelas, container, false)
        root.cvKelas.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.cvKelas->{
                findNavController().navigate(R.id.action_guruKelasFragment_to_guruKelasDetailFragment)
            }
        }
    }

}