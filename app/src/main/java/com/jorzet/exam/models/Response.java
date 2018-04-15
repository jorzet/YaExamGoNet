package com.jorzet.exam.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */
public class Response {

    @SerializedName("agente")
    @Expose
    private String agent;
    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("token")
    @Expose
    private String token;

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAgent() {
        return this.agent;
    }

    public Error getError() {
        return this.error;
    }

    public Integer getIdUser() {
        return this.idUser;
    }

    public String getToken() {
        return this.token;
    }

}
