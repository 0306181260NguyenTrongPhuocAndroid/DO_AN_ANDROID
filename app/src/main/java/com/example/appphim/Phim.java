package com.example.appphim;

public class Phim {
    private String name;
    private String dotuoi;
    private  String theloai;
    private String tuoi;
    private  String diem;
    private int img;

    public Phim(String name, String theloai, String tuoi, String diem, int img) {
        this.name = name;
        this.theloai = theloai;
        this.tuoi = tuoi;
        this.diem = diem;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDotuoi() {
        return dotuoi;
    }

    public void setDotuoi(String dotuoi) {
        this.dotuoi = dotuoi;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
