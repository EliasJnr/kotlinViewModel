package br.com.pemaza.newsapp_brasilnotcias.conf

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.pemaza.newsapp_brasilnotcias.activity.SignUpActivity
import br.com.pemaza.newsapp_brasilnotcias.fragment.SignUpAccessFragment
import br.com.pemaza.newsapp_brasilnotcias.fragment.SignUpPersonalFragment
import br.com.pemaza.newsapp_brasilnotcias.fragment.SignUpTermsFragment

class SectionsPagerAdapter(activity: SignUpActivity, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SignUpPersonalFragment()
            1 -> SignUpAccessFragment()
            else -> SignUpTermsFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

}