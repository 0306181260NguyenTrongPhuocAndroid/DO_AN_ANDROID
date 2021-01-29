package com.example.appphim;


import java.sql.Date;

public class SuatChieu {
    public int CinemaID;
    public int RoomId;
    public int suatChieuID;
    public Date ngayChieu;
    public int gioBatDau;
    public int trangThai;

    public SuatChieu() {
    }

    public SuatChieu(int cinemaID, int roomId, int suatChieuID, Date ngayChieu, int gioBatDau, int trangThai) {
        CinemaID = cinemaID;
        RoomId = roomId;
        this.suatChieuID = suatChieuID;
        this.ngayChieu = ngayChieu;
        this.gioBatDau = gioBatDau;
        this.trangThai = trangThai;
    }
}
