package com.example.appphim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.LinkedList;

public class Activity_Chonghe extends AppCompatActivity {

    public static int colorClick;
    public static int colorNomal;
    public static ThongTinLichChieu thongTinLichChieu;
    public static LinkedList<Seat_Info> List_Seat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__chonghe);
        colorClick=getResources().getColor(R.color.red);
        colorNomal=getResources().getColor(R.color.white);

    }

    @SuppressLint("ResourceAsColor")
    public void GheClick(View view) {
        ImageButton img = (ImageButton) findViewById(view.getId());
        String th = img.getTag().toString();
        switch (th) {
            case "0": {
                ((ImageButton) findViewById(view.getId())).setBackgroundColor(colorClick);
                img.setTag("1");
                break;
            }
            case "1": {
                ((ImageButton) findViewById(view.getId())).setBackgroundColor(colorNomal);
                img.setTag("0");
                break;
            }
            default:
                break;
        }
    }

    public void DatveClick(View view) {

    }
}