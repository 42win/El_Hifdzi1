package com.az.elhifdzi.ui.santri

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.az.elhifdzi.R
import com.az.elhifdzi.adapter.santri.PagerSantriTahfizulAdapter
import com.az.elhifdzi.common.Common
import com.google.android.material.tabs.TabLayout


class SantriTahfizulBaseFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_santri_tahfizul_base, container, false)

        //set up viewpager
        viewPager = root.findViewById(R.id.viewPagerTahfizulAyat)
        tabs = root.findViewById(R.id.tabsTahfizulAyat)

        val fragmentAdapter =
            PagerSantriTahfizulAdapter(
                childFragmentManager
            )
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)
        (activity as AppCompatActivity).supportActionBar?.elevation = 0f
        //end

        (activity as AppCompatActivity).supportActionBar?.title= Common.surahSelected?.namaSurah

        return root
    }

}