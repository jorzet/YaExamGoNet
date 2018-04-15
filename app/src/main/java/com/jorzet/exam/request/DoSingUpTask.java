package com.jorzet.exam.request;

import android.content.Context;
import android.util.Log;

import com.jorzet.exam.models.User;
import com.jorzet.exam.services.webservice.MetadataInfo;

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

public class DoSingUpTask extends AbstractRequestTask {
    private Context mContext;
    private User mUser;

    public DoSingUpTask(Context context, User user){
        this.mContext = context;
        this.mUser = user;
    }

    @Override
    protected String getUrl() {
        return MetadataInfo.BASE_URL;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return MetadataInfo.requestSingup(mUser, mContext);
    }

    @Override
    protected void onPostExecute(Object response) {
        super.onPostExecute(response);

        Log.i("DoSingUp3: ","login:" + response);
        if (response==null || response.equals("") || ((String)response).contains("Error")) {
            onRequestFailListener.onFailed(response);
        } else {
            onRequestSuccessListener.onSuccess(response);
        }
    }
}
