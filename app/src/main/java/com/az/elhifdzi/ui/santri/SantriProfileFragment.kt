package com.az.elhifdzi.ui.santri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.az.elhifdzi.R
import kotlinx.android.synthetic.main.fragment_santri_profile.view.*

class SantriProfileFragment : Fragment(),View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_santri_profile, container, false)
        root.cvSantri.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.cvSantri->{
                findNavController().navigate(R.id.action_santriProfileFragment_to_santriProfileDetailFragment)
            }
        }
    }

}