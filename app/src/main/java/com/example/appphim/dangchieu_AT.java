package com.example.appphim;

public class dangchieu_AT {
    private int image;
    private String title;
    private String desc;
    private int imageStar;
    private String point;
    private int Id;


    public dangchieu_AT(int image, String title, String desc, int imageStar, String point,int id) {
        this.image = image;
        this.title = title;
        this.desc = desc;

        this.imageStar = imageStar;
        this.point = point;
        this.Id=id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageStar() {
        return imageStar;
    }

    public void setImageStar(int imageStar) {
        this.imageStar = imageStar;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
