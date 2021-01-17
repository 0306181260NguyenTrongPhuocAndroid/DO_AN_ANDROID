package com.example.appphim;

public class GiaoDich {

    private int Giave;
    private  int SoLuong;
    private int NgayDat;
    private  int TenPhim;

    public GiaoDich(int giave, int soLuong, int ngayDat, int tenPhim) {

        Giave = giave;
        SoLuong = soLuong;
        NgayDat = ngayDat;
        TenPhim = tenPhim;
    }

    public GiaoDich(String tenVe, int giaVe, String tenPhim, int ngayChieu) {
    }

    public int getGiave() {
        return Giave;
    }

    public void setGiave(int giave) {
        Giave = giave;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(int ngayDat) {
        NgayDat = ngayDat;
    }

    public int getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(int tenPhim) {
        TenPhim = tenPhim;
    }
}
