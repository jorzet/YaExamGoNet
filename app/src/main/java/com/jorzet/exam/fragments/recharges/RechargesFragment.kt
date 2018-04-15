package com.jorzet.exam.fragments.recharges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jorzet.exam.R
import com.jorzet.exam.fragments.content.BaseContentFragment

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

class RechargesFragment : BaseContentFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (container == null)
            return null

        val rootView = inflater?.inflate(R.layout.recharges_fragment, container, false)!!

        return rootView
    }
}