package com.example.son.gdghack.models;

/**
 * Created by S.O.N on 11/18/2017.
 */

public class Guest {
    private String date;
    private String time;
    private int numberOfGuests;

    public Guest(String date, String time, int numberOfGuests) {
        this.date = date;
        this.time = time;
        this.numberOfGuests = numberOfGuests;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
}
