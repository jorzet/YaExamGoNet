package com.jorzet.exam.ui.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.jorzet.exam.R

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

class RechargeActivity : BaseActivityLifeCycle() {

    private lateinit var mToolbar : Toolbar
    private lateinit var mBack : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharge)

        mToolbar = findViewById(R.id.toolbar)
        mBack = findViewById(R.id.backarrow)

        setSupportActionBar(mToolbar)
        mBack.setOnClickListener { this.onBackPressed() }
    }


}