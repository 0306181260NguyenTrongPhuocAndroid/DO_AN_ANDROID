package com.example.appphim;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class ThongTinLichChieu {
    private int CinemaID;
    private String CinemaName;
    private Date ngayChieu;
    private List<SuatChieu> dsSuatChieu;

    public ThongTinLichChieu() {
    }

    //Lấy dữ liệu

    public int getCinemaID() {
        return CinemaID;
    }

    public void setCinemaID(int cinemaID) {
        CinemaID = cinemaID;
    }

    public String getCinemaName() {
        return CinemaName;
    }

    public void setCinemaName(String cinemaName) {
        CinemaName = cinemaName;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public List<SuatChieu> getDsSuatChieu() {
        return dsSuatChieu;
    }

    public void setDsSuatChieu(List<SuatChieu> dsSuatChieu) {
        this.dsSuatChieu = dsSuatChieu;
    }
}
