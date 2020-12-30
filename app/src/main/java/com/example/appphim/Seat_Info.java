package com.example.appphim;

public class Seat_Info {
    private int SeatId;
    private String SeatName;
    private int SeatStatus;
    private double SeatPrice;

    public Seat_Info() {
    }

    public Seat_Info(int seatId, String seatName, int seatStatus, double seatPrice) {
        SeatId = seatId;
        SeatName = seatName;
        SeatStatus = seatStatus;
        SeatPrice = seatPrice;
    }

    public int getSeatId() {
        return SeatId;
    }

    public String getSeatName() {
        return SeatName;
    }

    public int getSeatStatus() {
        return SeatStatus;
    }

    public double getSeatPrice() {
        return SeatPrice;
    }

    public void setSeatId(int seatId) {
        SeatId = seatId;
    }

    public void setSeatName(String seatName) {
        SeatName = seatName;
    }

    public void setSeatStatus(int seatStatus) {
        SeatStatus = seatStatus;
    }

    public void setSeatPrice(double seatPrice) {
        SeatPrice = seatPrice;
    }
}
