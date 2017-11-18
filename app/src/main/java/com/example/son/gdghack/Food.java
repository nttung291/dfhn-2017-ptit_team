package com.example.son.gdghack;

/**
 * Created by hoang on 11/18/2017.
 */

public class Food {
    private String fname;
    private String price;

    public Food() {
    }

    public Food(String fname, String price) {
        this.fname = fname;
        this.price = price;
    }

    public String getFname() {
        return fname;
    }

    public String getPrice() {
        return price;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
