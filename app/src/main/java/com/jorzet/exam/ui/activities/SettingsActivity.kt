package com.jorzet.exam.ui.activities

import android.os.Bundle
import com.jorzet.exam.R

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

class SettingsActivity : BaseActivityLifeCycle() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
}