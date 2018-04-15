package com.jorzet.exam.models;

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

public class RechargeItem {
    private String name;
    private int image;

    public RechargeItem(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public int getImage() {
        return this.image;
    }
}
