package com.example.appphim;

import java.util.Date;
import java.util.List;

public class FilmTicket {
    private int CinemaID;
    private int SuatID;
    private int FilmID;
    private int PhongID;
    private double GiaVe;
    private List<Integer> mListGheID;
    private int Status;

    public FilmTicket() {
    }

    public FilmTicket(int cinemaID, int suatID, int filmID, int phongID, double giaVe, List<Integer> mListGheID, int status) {
        CinemaID = cinemaID;
        SuatID = suatID;
        FilmID = filmID;
        PhongID = phongID;
        GiaVe = giaVe;
        this.mListGheID = mListGheID;
        Status = status;
    }

    public int getCinemaID() {
        return CinemaID;
    }

    public void setCinemaID(int cinemaID) {
        CinemaID = cinemaID;
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

    public List<Integer> getmListGheID() {
        return mListGheID;
    }

    public void setmListGheID(List<Integer> mListGheID) {
        this.mListGheID = mListGheID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
