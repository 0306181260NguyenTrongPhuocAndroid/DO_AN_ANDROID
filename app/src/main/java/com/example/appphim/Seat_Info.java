package com.example.appphim;

public class Seat_Info {
    private int SeatId;
    private int SeatKind;
    private int SeatStatus;
    private double SeatPrice;

    public Seat_Info() {
    }

    public Seat_Info(int seatId, int seatKind, int seatStatus, double seatPrice) {
        SeatId = seatId;
        SeatKind = seatKind;
        SeatStatus = seatStatus;
        SeatPrice = seatPrice;
    }

    public int getSeatId() {
        return SeatId;
    }

    public int getSeatKind() {
        return SeatKind;
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

    public void setSeatKind(int seatKind) {
        SeatKind = seatKind;
    }

    public void setSeatStatus(int seatStatus) {
        SeatStatus = seatStatus;
    }

    public void setSeatPrice(double seatPrice) {
        SeatPrice = seatPrice;
    }
}
