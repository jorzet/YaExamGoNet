package com.jorzet.exam.fragments.content;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.jorzet.exam.models.Response;
import com.jorzet.exam.models.User;
import com.jorzet.exam.models.User_;
import com.jorzet.exam.request.ContentRequestManager;


/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

public abstract class BaseContentFragment extends Fragment {

    private ContentRequestManager mContentRequestManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContentRequestManager = new ContentRequestManager(getContext());
    }


    protected void requestDoLogIn(String email, String password) {
        User_ user = new User_(email, password);
        mContentRequestManager.requestDoLogIn(user, new ContentRequestManager.OnDoLogInListener(){
            @Override
            public void onDoLogInLoaded(Response result) {
                Log.i("DoLogIn1: ","login:" + result);
                onDoLogInSuccess(result);
            }

            @Override
            public void onDoLogInError(String throwable) {
                onDoLogInFail(throwable);
            }
        });
    }

    protected void requestSingUpPatient(User patient) {
        mContentRequestManager.requestSingUpPatient(patient, new ContentRequestManager.OnSingUpPatientListener(){
            @Override
            public void onSingUpPatientLoaded(String result) {
                Log.i("DoLogIn1: ","login:" + result);
                onSingUpUserSuccess(result);
            }

            @Override
            public void onSingUpPatientError(String throwable) {
                onSingUpUserFail(throwable);
            }
        });
    }

    public void onDoLogInSuccess(Response response) {
    }

    public void onDoLogInFail(String response) {
    }

    public void onSingUpUserSuccess(String response) {
    }

    public void onSingUpUserFail(String response) {
    }

}
