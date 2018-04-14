package com.jorzet.exam.fragments.singinandsingup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.google.gson.Gson
import com.jorzet.exam.R
import com.jorzet.exam.fragments.content.BaseContentFragment
import com.jorzet.exam.models.Response
import com.jorzet.exam.models.User
import com.jorzet.exam.services.database.DataBase
import com.jorzet.exam.ui.activities.ContentActivity

/**
 * Created by jorge on 14/04/18.
 */

class SingInFragment : BaseContentFragment() {

    /* UI accessors */
    private lateinit var mUserEditText : EditText
    private lateinit var mPasswordEditText : EditText
    private lateinit var mLogInButton : Button
    private lateinit var mLoadingProgressBar : ProgressBar
    private lateinit var mLoginContent : View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (container == null)
            return null

        val rootView = inflater?.inflate(R.layout.login_fragment, container, false)!!

        mUserEditText = rootView.findViewById(R.id.et_email)
        mPasswordEditText = rootView.findViewById(R.id.et_password)
        mLogInButton = rootView.findViewById(R.id.btn_login)
        mLoadingProgressBar = rootView.findViewById(R.id.pb_loading)
        mLoginContent = rootView.findViewById(R.id.rl_login_inputs)

        mLogInButton.setOnClickListener(mLogInListener)

        return rootView
    }

    private fun doLogin(){
        val user = mUserEditText.text.toString()
        val pass = mPasswordEditText.text.toString()

        if (!user.equals("") && !pass.equals("")) {
            requestDoLogIn(user, pass)
            showLoading()
        } else {
            showError()
        }
    }

    private fun showError() {

    }

    private fun showLoading() {
        mLoginContent.setVisibility(View.GONE)
        mLoadingProgressBar.setVisibility(View.VISIBLE)
    }

    private fun hideLoading() {
        mLoginContent.setVisibility(View.VISIBLE)
        mLoadingProgressBar.setVisibility(View.GONE)
    }

    private fun goContentActivity() {
        val intent = Intent(activity, ContentActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    private val mLogInListener : View.OnClickListener = View.OnClickListener {
        doLogin()
    }

    override fun onDoLogInSuccess(response: Response?) {
        super.onDoLogInSuccess(response)

        hideLoading()

        val res = Gson().toJson(response).toString()
        DataBase(context).storeLoginJSON(res)

        //if (idUser != null)
            goContentActivity()
    }

    override fun onDoLogInFail(response: String?) {
        super.onDoLogInFail(response)
        hideLoading()
    }
}