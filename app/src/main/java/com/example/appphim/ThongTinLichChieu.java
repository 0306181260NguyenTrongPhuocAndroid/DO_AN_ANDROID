package com.example.appphim;

import java.sql.Date;
import java.util.LinkedList;

public class ThongTinLichChieu {
    private int CinemaID;
    private int phimID;
    private String CinemaName;
    private int RoomId;
    private String RoomName;
    private Date ngayChieu;
    private LinkedList<SuatChieu> dsSuatChieu;

    public ThongTinLichChieu() {
    }

    public ThongTinLichChieu(int cinemaID, int phimID, String cinemaName, int roomId,
                             String roomName, Date ngayChieu, LinkedList<SuatChieu> dsSuatChieu) {
        CinemaID = cinemaID;
        this.phimID = phimID;
        CinemaName = cinemaName;
        RoomId = roomId;
        RoomName = roomName;
        this.ngayChieu = ngayChieu;
        this.dsSuatChieu = dsSuatChieu;
    }

    //Lấy dữ liệu


    public int getPhimID() {
        return phimID;
    }

    public void setPhimID(int phimID) {
        this.phimID = phimID;
    }

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

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int roomId) {
        RoomId = roomId;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public LinkedList<SuatChieu> getDsSuatChieu() {
        return dsSuatChieu;
    }

    public void setDsSuatChieu(LinkedList<SuatChieu> dsSuatChieu) {
        this.dsSuatChieu = dsSuatChieu;
    }
}
