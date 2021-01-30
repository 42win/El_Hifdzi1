package com.az.elhifdzi.ui.santri

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.az.elhifdzi.R
import kotlinx.android.synthetic.main.fragment_santri_home.view.*


class SantriHomeFragment : Fragment(),View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_santri_home, container, false)

        root.btnLearning.setOnClickListener(this)
        root.btnTahfizul.setOnClickListener(this)
        root.btnTaqdimul.setOnClickListener(this)
        return  root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //inflate memnu
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //handle menu item clicks
        var id = item.itemId
        if(id==R.id.btnNotif){
            findNavController().navigate(R.id.santriNotifFragment)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnLearning->{
                findNavController().navigate(R.id.action_santriHomeFragment_to_santriLearningVideoFragment)
            }
            R.id.btnTahfizul->{
                findNavController().navigate(R.id.action_santriHomeFragment_to_santriTahfizulSurahFragment)
            }
            R.id.btnTaqdimul->{
                findNavController().navigate(R.id.action_santriHomeFragment_to_santriTaqdimulFragment)
            }
        }
    }

}