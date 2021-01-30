package com.az.elhifdzi.ui.guru

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.az.elhifdzi.R
import kotlinx.android.synthetic.main.fragment_guru_home.view.*

class GuruHomeFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_guru_home, container, false)
        root.cvKelas.setOnClickListener(this)
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //inflate memnu
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.cvKelas->{
                findNavController().navigate(R.id.action_guruHomeFragment_to_guruKelasFragment)
            }
        }
    }
}