package com.example.son.gdghack.models;

/**
 * Created by S.O.N on 11/18/2017.
 */

public class Table {
    private String description;
    private String floor;
    private Long pricePerSeat;
    private int seatAmount;
    private int tableNo;
    private int status;

    public Table() {
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

    public Long getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(Long pricePerSeat) {
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

    public Table(String description, String floor, Long pricePerSeat, int seatAmount, int tableNo) {
        this.description = description;
        this.floor = floor;
        this.pricePerSeat = pricePerSeat;
        this.seatAmount = seatAmount;
        this.tableNo = tableNo;
    }

    @Override
    public String toString() {
        return "Table{" +
                "description='" + description + '\'' +
                ", floor='" + floor + '\'' +
                ", pricePerSeat=" + pricePerSeat +
                ", seatAmount=" + seatAmount +
                ", tableNo=" + tableNo +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
