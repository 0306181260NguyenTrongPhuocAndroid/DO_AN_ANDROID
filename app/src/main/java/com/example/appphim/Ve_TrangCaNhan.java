package com.example.appphim;

public class Ve_TrangCaNhan {
    String tenVe;
    int Gia;

    public Ve_TrangCaNhan(String tenVe, int gia) {
        this.tenVe = tenVe;
        Gia = gia;
    }

    public String getTenVe() {
        return tenVe;
    }

    public void setTenVe(String tenVe) {
        this.tenVe = tenVe;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }
}
