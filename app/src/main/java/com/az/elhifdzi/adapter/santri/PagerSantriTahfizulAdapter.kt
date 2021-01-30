package com.az.elhifdzi.adapter.santri

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.az.elhifdzi.R
import com.az.elhifdzi.ui.santri.SantriTahfizulAyatFragment
import org.jetbrains.annotations.Nullable

class PagerSantriTahfizulAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES = intArrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3)

    override fun getItem(position: Int): Fragment {
//        var fragment: Fragment? = null
//        when (position) {
//            0 -> fragment = SantriTahfizulAyatFragment()
//            1 -> fragment = SantriTahfizulAyatFragment()
//        }
        val fragment =
            SantriTahfizulAyatFragment.newInstance(
                position + 1
            )
        return fragment as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        var title : CharSequence ? = null
        when (position) {
            0 -> title = "Ayat 1"
            1 -> title = "Ayat 2"
            2 -> title = "Ayat 3"
        }
        return title
    }

    override fun getCount(): Int {
        return 3
    }

}