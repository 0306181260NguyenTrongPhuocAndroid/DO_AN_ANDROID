package com.example.appphim;


import java.sql.Date;

public class SuatChieu {
    public int suatChieuID;
    public Date ngayChieu;
    public int gioBatDau;
    public int trangThai;

    public SuatChieu() {
    }

    public SuatChieu(int suatChieuID, Date ngayChieu, int gioBatDau, int trangThai) {
        this.suatChieuID = suatChieuID;
        this.ngayChieu = ngayChieu;
        this.gioBatDau = gioBatDau;
        this.trangThai = trangThai;
    }
}
