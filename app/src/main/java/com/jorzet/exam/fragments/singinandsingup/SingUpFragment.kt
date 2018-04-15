package com.jorzet.exam.fragments.singinandsingup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jorzet.exam.fragments.content.BaseContentFragment

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

class SingUpFragment : BaseContentFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onSingUpUserSuccess(response: String?) {
        super.onSingUpUserSuccess(response)
    }

    override fun onSingUpUserFail(response: String?) {
        super.onSingUpUserFail(response)
    }
}