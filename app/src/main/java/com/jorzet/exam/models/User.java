package com.jorzet.exam.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorge on 14/04/18.
 */

public class User {
    @SerializedName("")
    @Expose()
    private String user;
    @SerializedName("")
    @Expose
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }
}
