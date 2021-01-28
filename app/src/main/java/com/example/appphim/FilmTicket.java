package com.example.appphim;

import java.util.Date;

public class FilmTicket {
    private Date NgayBan;
    private int SuatID;
    private int FilmID;
    private int PhongID;
    private double GiaVe;
    private int GheID;
    private int Status;

    public FilmTicket() {
    }

    public FilmTicket(Date ngayBan, int suatID, int filmID, int phongID, double giaVe, int gheID, int status) {
        NgayBan = ngayBan;
        SuatID = suatID;
        FilmID = filmID;
        PhongID = phongID;
        GiaVe = giaVe;
        GheID = gheID;
        Status = status;
    }

    public Date getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(Date ngayBan) {
        NgayBan = ngayBan;
    }

    public int getSuatID() {
        return SuatID;
    }

    public void setSuatID(int suatID) {
        SuatID = suatID;
    }

    public int getFilmID() {
        return FilmID;
    }

    public void setFilmID(int filmID) {
        FilmID = filmID;
    }

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int phongID) {
        PhongID = phongID;
    }

    public double getGiaVe() {
        return GiaVe;
    }

    public void setGiaVe(double giaVe) {
        GiaVe = giaVe;
    }

    public int getGheID() {
        return GheID;
    }

    public void setGheID(int gheID) {
        GheID = gheID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
