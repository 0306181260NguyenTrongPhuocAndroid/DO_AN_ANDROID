package com.example.appphim;

import java.sql.Date;
import java.util.LinkedList;

public class ThongTinLichChieu {
    private String CinemaName;
    private String filmName;
    private String RoomId;
    private Date ngayChieu;
    private LinkedList<SuatChieu> dsSuatChieu;

    public ThongTinLichChieu() {
    }

    public ThongTinLichChieu(String cinemaName, String filmName, String roomId, Date ngayChieu, LinkedList<SuatChieu> dsSuatChieu) {
        CinemaName = cinemaName;
        this.filmName = filmName;
        RoomId = roomId;
        this.ngayChieu = ngayChieu;
        this.dsSuatChieu = dsSuatChieu;
    }

    //Lấy dữ liệu
    public String getCinemaName() {
        return CinemaName;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getRoomId() {
        return RoomId;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public LinkedList<SuatChieu> getDsSuatChieu() {
        return dsSuatChieu;
    }

    //Gán dữ liệu
    public void setCinemaName(String cinemaName) {
        CinemaName = cinemaName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setRoomId(String roomId) {
        RoomId = roomId;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public void setDsSuatChieu(LinkedList<SuatChieu> dsSuatChieu) {
        this.dsSuatChieu = dsSuatChieu;
    }
}
