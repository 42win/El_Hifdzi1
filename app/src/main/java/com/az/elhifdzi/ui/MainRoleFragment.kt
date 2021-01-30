package com.az.elhifdzi.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.az.elhifdzi.R
import com.az.elhifdzi.ui.guru.GuruActivity
import com.az.elhifdzi.ui.santri.SantriActivity
import kotlinx.android.synthetic.main.fragment_main_role.view.*

class MainRoleFragment : Fragment(),View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_main_role, container, false)

        root.cvSantri.setOnClickListener(this)
        root.cvGuru.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.cvSantri->{
                activity?.startActivity(Intent(activity, SantriActivity::class.java))
            }
            R.id.cvGuru->{
                activity?.startActivity(Intent(activity, GuruActivity::class.java))
            }
        }
    }

}