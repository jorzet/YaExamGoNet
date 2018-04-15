package com.jorzet.exam.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.jorzet.exam.R
import com.jorzet.exam.fragments.singinandsingup.SingInFragment

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

class LoginActivity : BaseActivityLifeCycle() {

    /* UI accessors */
    private lateinit var mUserEditText : EditText
    private lateinit var mPasswordEditText : EditText
    private lateinit var mLogInButton : Button
    private lateinit var mLoadingProgressBar : ProgressBar
    private lateinit var mLoginContent : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_container)

        val manager = getSupportFragmentManager();
        val transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, SingInFragment());
        transaction.addToBackStack(null)
        transaction.commit()
    }

}