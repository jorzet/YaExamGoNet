package com.jorzet.exam.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jorzet.exam.R
import com.jorzet.exam.fragments.content.BaseContentFragment

/**
 * Created by jorge on 14/04/18.
 */

class AdministrationFragment : BaseContentFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (container == null)
            return null

        val rootView = inflater?.inflate(R.layout.administration_fragment, container, false)!!

        return rootView
    }

}