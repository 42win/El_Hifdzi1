package com.az.elhifdzi.ui.santri

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.az.elhifdzi.R
import kotlinx.android.synthetic.main.fragment_santri_tahfizul_ayat.*
import kotlinx.android.synthetic.main.fragment_santri_tahfizul_ayat.view.*

class SantriTahfizulAyatFragment : Fragment(),View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_santri_tahfizul_ayat, container, false)


        root.btnFinish.setOnClickListener(this)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var index = 1
        if (getArguments() != null) {
            index = arguments?.getInt(ARG_SECTION_NUMBER, 0) as Int
        }

        if(index==3){
            btnFinish.visibility = View.VISIBLE
        }

        section_label.text = "${getString(R.string.content_tab_text)} $index"
    }

    companion object{
        private val ARG_SECTION_NUMBER = "section number"

        fun newInstance(index: Int): SantriTahfizulAyatFragment{
            val fragment = SantriTahfizulAyatFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_SECTION_NUMBER, index)

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnFinish->{
                findNavController().navigate(R.id.action_santriTahfizulBaseFragment_to_santriTahfizulResultFragment)

            }
        }
    }

}