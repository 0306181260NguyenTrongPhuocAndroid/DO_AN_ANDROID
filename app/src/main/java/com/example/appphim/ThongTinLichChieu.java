package com.example.appphim;

import java.sql.Date;
import java.sql.Time;

public class ThongTinLichChieu {
    private String CinemaName;
    private String RoomId;
    private Date ngayChieu;
    private Time suatChieu;
    private String filmName;

    public ThongTinLichChieu(String cinemaName, String roomId, Date ngayChieu, Time suatChieu, String filmName) {
        CinemaName = cinemaName;
        RoomId = roomId;
        this.ngayChieu = ngayChieu;
        this.suatChieu = suatChieu;
        this.filmName = filmName;
    }

    public ThongTinLichChieu() {
    }

    public String getCinemaName() {
        return CinemaName;
    }

    public String getRoomId() {
        return RoomId;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public Time getSuatChieu() {
        return suatChieu;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setCinemaName(String cinemaName) {
        CinemaName = cinemaName;
    }

    public void setRoomId(String roomId) {
        RoomId = roomId;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public void setSuatChieu(Time suatChieu) {
        this.suatChieu = suatChieu;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
}
