package com.jorzet.exam.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.jorzet.exam.R

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

class SplashActivity : BaseActivityLifeCycle() {

    /* to set delay */
    private val TIME_DELAY : Long = 5000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initHandler()
    }

    private fun initHandler() {
        Handler().postDelayed({showProgressBar()}, TIME_DELAY)
    }

    private fun showProgressBar() {
        Thread(Runnable {
            goLogInActivity()
        }).start()
    }

    private fun goLogInActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        this.startActivity(intent)
        this.finish()
    }
}
