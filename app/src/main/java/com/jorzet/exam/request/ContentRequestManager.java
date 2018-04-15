package com.jorzet.exam.request;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.jorzet.exam.models.Response;
import com.jorzet.exam.models.User;
import com.jorzet.exam.models.User_;

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

public class ContentRequestManager {

    private Context mContext;

    public ContentRequestManager(Context context){
        this.mContext = context;
    }

    public void requestDoLogIn(User_ user, final OnDoLogInListener onDoLogInListener){
        DoLogInTask mDoLogInTask = new DoLogInTask(mContext, user);

        mDoLogInTask.setOnRequestSuccess(new AbstractRequestTask.OnRequestListenerSuccess() {
            @Override
            public void onSuccess(Object result) {
                Log.i("DoLogIn2: ","login:" + result);
                Response response = new Gson().fromJson((String)result, Response.class);
                onDoLogInListener.onDoLogInLoaded(response);
            }
        });

        mDoLogInTask.setOnRequestFailed(new AbstractRequestTask.OnRequestListenerFailed() {
            @Override
            public void onFailed(Object result) {
                onDoLogInListener.onDoLogInError((String)result);
            }
        });

        try {
            mDoLogInTask.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void requestSingUpPatient(User user, final OnSingUpPatientListener onSingUpPatientListener){
        DoSingUpTask mDoSingUpTask = new DoSingUpTask(mContext, user);

        mDoSingUpTask.setOnRequestSuccess(new AbstractRequestTask.OnRequestListenerSuccess() {
            @Override
            public void onSuccess(Object result) {
                Log.i("DoSingUp2: ","singup:" + result);
                onSingUpPatientListener.onSingUpPatientLoaded((String)result);
            }
        });

        mDoSingUpTask.setOnRequestFailed(new AbstractRequestTask.OnRequestListenerFailed() {
            @Override
            public void onFailed(Object result) {
                onSingUpPatientListener.onSingUpPatientError((String)result);
            }
        });

        try {
            mDoSingUpTask.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public interface OnDoLogInListener{
        void onDoLogInLoaded(Response result);
        void onDoLogInError(String throwable);
    }

    public interface OnSingUpPatientListener{
        void onSingUpPatientLoaded(String result);
        void onSingUpPatientError(String throwable);
    }

}
