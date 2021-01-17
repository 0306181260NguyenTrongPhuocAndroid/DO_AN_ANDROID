package com.example.appphim;

public class ThanhVien {
    private int Id;
    private  String Username;
    private  String MatKhau;
    private  int GioiTinh;
    private int NgaySinh;
    private String Email;
    private  String SDT;

    public ThanhVien(int id, String username, String matKhau, int gioiTinh, int ngaySinh, String email, String SDT) {
        Id = id;
        Username = username;
        MatKhau = matKhau;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        Email = email;
        this.SDT = SDT;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public int getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(int ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
