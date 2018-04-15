package com.jorzet.exam.adapters


import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.jorzet.exam.fragments.AdministrationFragment
import com.jorzet.exam.fragments.CollectionFragment
import com.jorzet.exam.fragments.PinFragment
import com.jorzet.exam.fragments.RechargesFragment
/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

class MainContainerViewPager(context : Context, fm: FragmentManager, tabCount : Int) : FragmentStatePagerAdapter(fm) {

    private val mTotalPages : Int = tabCount

    override fun getItem(position: Int): Fragment {
        var fragment = Fragment()
        when(position){
            0 -> fragment = PinFragment()
            1 -> fragment = RechargesFragment()
            2 -> fragment = CollectionFragment()
            3 -> fragment = AdministrationFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return mTotalPages
    }
}