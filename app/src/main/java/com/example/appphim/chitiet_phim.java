package com.example.appphim;

public class chitiet_phim {
    private int id;
    private String tenPhim;
    private String soDiem;
    private String doTuoi;
    private String theLoai;
    private String moTa;
    private String trailer;

    public chitiet_phim(int id, String tenPhim, String soDiem, String doTuoi, String theLoai, String moTa, String trailer) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.soDiem = soDiem;
        this.doTuoi = doTuoi;
        this.theLoai = theLoai;
        this.moTa = moTa;
        this.trailer = trailer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(String soDiem) {
        this.soDiem = soDiem;
    }

    public String getDoTuoi() {
        return doTuoi;
    }

    public void setDoTuoi(String doTuoi) {
        this.doTuoi = doTuoi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
