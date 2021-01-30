package com.az.elhifdzi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.az.elhifdzi.R
import kotlinx.android.synthetic.main.fragment_main_login.view.*


class MainLoginFragment : Fragment(),View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_main_login, container, false)
        root.btnLogin.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnLogin->{
                findNavController().navigate(R.id.action_mainLoginFragment_to_mainRoleFragment)
            }
        }
    }

}