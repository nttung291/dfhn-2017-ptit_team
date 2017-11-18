package com.example.son.gdghack;

/**
 * Created by hoang on 11/18/2017.
 */

public class Food {
    private String name;
    private Long price;
    private String description;
    private String imgUrl;

    public Food() {
    }

    public Food(String name, Long price, String description, String imgUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public String getname() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public void setFname(String fname) {
        this.name = fname;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


}
