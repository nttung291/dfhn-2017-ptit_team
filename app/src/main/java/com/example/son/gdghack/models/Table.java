package com.example.son.gdghack.models;

/**
 * Created by S.O.N on 11/18/2017.
 */

public class Table {
    private String description;
    private String floor;
    private String pricePerSeat;
    private int seatAmount;
    private int tableNo;

    public Table(String description, String floor, String pricePerSeat, int seatAmount, int tableNo) {
        this.description = description;
        this.floor = floor;
        this.pricePerSeat = pricePerSeat;
        this.seatAmount = seatAmount;
        this.tableNo = tableNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(String pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
}
