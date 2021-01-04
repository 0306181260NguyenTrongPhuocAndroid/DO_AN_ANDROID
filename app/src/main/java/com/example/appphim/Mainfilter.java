package com.example.appphim;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Mainfilter extends AppCompatActivity {
    List<Phim> Phims;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfilter);
        Phims = new ArrayList<>();
        Phims.add(new Phim("MẮT BIẾT","Thể loại: Tình cảm","Tuổi: 16+","Điểm: 8 điểm",R.drawable.a));
        Phims.add(new Phim("TRẠNG QUỲNH","Thể loại: Hài hước, tình cảm","Tuổi: 16+","Điểm: 9 điểm",R.drawable.download));
        Phims.add(new Phim("CHỊ MƯỜI BA","Thể loại: Hài hước, hành động","Tuổi: 16+","Điểm: 7 điểm",R.drawable.chimuoiba));
        Phims.add(new Phim("RÒM","Thể loại: Tâm lý","Tuổi: 16+","Điểm: 8 điểm",R.drawable.rom));
        Phims.add(new Phim("CHỒNG NGƯỜI TA","Thể loại: Tình cảm","Tuổi: 16+","Điểm: 8.5 điểm",R.drawable.chongngta));
        Phims.add(new Phim("KẺ SĂN MỘ","Thể loại: Kinh dị","Tuổi: 16+","Điểm: 7 điểm",R.drawable.kesanmo));
        RecyclerView recycle = (RecyclerView)findViewById(R.id.recycle);
        timkiemAdapter adapter= new timkiemAdapter(this,Phims);
        recycle.setLayoutManager(new GridLayoutManager(this,1));
        recycle.setAdapter(adapter);


    }

    public void Search(View view) {
    }


}
