package com.jorzet.exam.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorge on 14/04/18.
 */

public class User_ {
    private String user;
    private String pass;

    public User_(String user, String password) {
        this.user = user;
        this.pass = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.pass;
    }
}
