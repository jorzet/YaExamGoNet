package com.jorzet.exam.services.webservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.google.gson.Gson;
import com.jorzet.exam.models.User;
import com.jorzet.exam.models.User_;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

public class HttpRequest {

    private static final int CONNECT_TIMEOUT = 5000; // 5 seconds
    private static final int READ_TIMEOUT = 15000; // 15 seconds
    private static final String OS = "OS";
    private static final String VERSION = "Version";

    public static boolean isConnected(final Context context) {
        if (context == null)
            return false;

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null
                && networkInfo.isConnectedOrConnecting();
    }

    public static String sendLogInRequest(User_ user, String url) {
        URL urlObj = null;
        try {
            urlObj = new URL(url);
        } catch (MalformedURLException e) {

        }

        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) urlObj.openConnection();
            urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
            urlConnection.setReadTimeout(READ_TIMEOUT);
            urlConnection.setUseCaches(true);
            urlConnection.setRequestProperty(OS, "Android");
            urlConnection.setRequestProperty(VERSION, "2.5.2");
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");

            JSONObject userJson = new JSONObject();
            JSONObject data = new JSONObject();
            try {
                userJson.put("user",user.getUser());
                userJson.put("pass",user.getPassword());
                data.put("data", userJson);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.e("sendRequest", "json: " + data);

            byte[] outputBytes = data.toString().getBytes("UTF-8");
            OutputStream os = urlConnection.getOutputStream();
            os.write(outputBytes);

            int responseCode = urlConnection.getResponseCode();


            InputStream is = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder total = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                total.append(line);
            }

            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            return total.toString();
        } catch (IOException e) {
            Log.e("IOException",e.getMessage());
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            return null;
        } finally {
            Log.i("Connection","Get request");
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }


    public static String sendSingUpRequest(String url)  {
        URL urlObj = null;
        try {
            urlObj = new URL(url);
        } catch (MalformedURLException e) {

        }

        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) urlObj.openConnection();
            urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
            urlConnection.setReadTimeout(READ_TIMEOUT);
            urlConnection.setUseCaches(true);
            urlConnection.setRequestProperty(OS, "Android");
            urlConnection.setRequestProperty(VERSION, "2.5.2");
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");

            JSONObject data = new JSONObject();
            JSONObject user = new JSONObject();

            try {

                user.put("pass","password");
                user.put("user","Luis");
                data.put("data", user);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.e("sendRequest", "12 - root : " + data.toString());

            String str = data.toString();
            byte[] outputBytes = str.getBytes("UTF-8");
            OutputStream os = urlConnection.getOutputStream();
            os.write(outputBytes);

            int responseCode = urlConnection.getResponseCode();


            InputStream is = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder total = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                total.append(line);
            }

            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            return total.toString();
        } catch (IOException e) {
            Log.e("IOException",e.getMessage());
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            return null;
        } finally {
            Log.i("Connection","Get request");
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}