package com.example.appphim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.LinkedList;

class Activity_ChonGhe extends AppCompatActivity {

    private static LinkedList<Seat_Info> dsGHE;
    private RecyclerView rcvDsghe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__chon_ghe);

        rcvDsghe=findViewById(R.id.dsGHE);
        rcvDsghe.setLayoutManager(new GridLayoutManager(this,7));
        TaoDSGHE();

        GheAdapter ga = new GheAdapter();
        ga.setDuLieu(dsGHE);
        rcvDsghe.setAdapter(ga);

    }

    public void GheClick(View view) {

        //Button btn = (Button)findViewById(view.getId());
        Button btn = (Button)view;

        switch (btn.getTag().toString())
        {
            case "0":{
                btn.setBackgroundResource(R.color.red);btn.setTag("1");
                break;
            }
            case "1":{
                btn.setBackgroundResource(R.color.white);btn.setTag("0");
                break;
            }
            default:break;
        }
    }

    public void DatveClick(View view) {
        Intent datve = new Intent(this,MainActivityThanhToan.class);
        startActivity(datve);
    }

    public void TaoDSGHE(){
        dsGHE = new LinkedList<Seat_Info>();
        for (int i=0;i<28;i++){
            Seat_Info g = new Seat_Info();
            g.setSeatId(i+1);
            g.setSeatStatus(i%3);
            g.setSeatPrice(50000.0);
            if(i<7){
                g.setSeatName("A"+(i%7+1)); dsGHE.add(g);
            continue; }
            if (i<14){
                g.setSeatName("B"+(i%7+1)); dsGHE.add(g);
            continue;}
            if(i<21){
                g.setSeatName("C"+(i%7+1)); dsGHE.add(g);
                continue;
            }
            g.setSeatName("D"+(i%7+1));
            dsGHE.add(g);
        }
    }
}