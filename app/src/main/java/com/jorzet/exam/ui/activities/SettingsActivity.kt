package com.jorzet.exam.ui.activities

import android.os.Bundle
import com.jorzet.exam.R

/**
 * Created by jorge on 14/04/18.
 */

class SettingsActivity : BaseActivityLifeCycle() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
}