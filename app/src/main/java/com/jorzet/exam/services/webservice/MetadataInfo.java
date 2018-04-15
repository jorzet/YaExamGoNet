package com.jorzet.exam.services.webservice;

import android.content.Context;

import com.jorzet.exam.R;
import com.jorzet.exam.models.User;
import com.jorzet.exam.models.User_;

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

public class MetadataInfo {
    public static final String BASE_URL = "https://agentemovil.pagatodo.com/AgenteMovil.svc/agMov/login";

    public static String requestLogin(User_ user, Context context){
        if(HttpRequest.isConnected(context))
            return HttpRequest.sendLogInRequest(user, BASE_URL);
        else
            return context.getResources().getString(R.string.error_from_network_not_connected);
    }

    public static String requestSingup(User user, Context context){
        if(HttpRequest.isConnected(context))
            return HttpRequest.sendSingUpRequest(BASE_URL);
        else
            return context.getResources().getString(R.string.error_from_network_not_connected);
    }
}
