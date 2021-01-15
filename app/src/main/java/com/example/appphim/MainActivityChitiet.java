package com.example.appphim;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivityChitiet extends AppCompatActivity {
    private ImageView image;
    private int id;


    private RatingBar ratingBarYours;
    private TextView textViewAverageAllRating;
    private List<Float> allRatings = new ArrayList<Float>();

    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewpagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chitiet);

        image= findViewById(R.id.hinhPhim);
//        Intent intent=this.getIntent();
//        ArrayList<dangchieu_AT> list = (ArrayList<dangchieu_AT>) intent.getSerializableExtra("list");



        mTablayout=findViewById(R.id.DetailsTablayout);
        mViewPager=findViewById(R.id.Detailsviewpager);

        mViewpagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        mViewPager.setAdapter(mViewpagerAdapter);

        mTablayout.setupWithViewPager(mViewPager);

        //mViewPager.beginFakeDrag();


        this.ratingBarYours = (RatingBar) this.findViewById(R.id.ratingBar_yours);
        this.textViewAverageAllRating= (TextView) this.findViewById(R.id.Diem);
        //setmTablayout();
    }

    public void Danhgia(View view) {
        float rating = this.ratingBarYours.getRating();
        this.allRatings.add(rating);
        int ratingCount = this.allRatings.size();
        float ratingSum = 0f;
        for(Float r: this.allRatings)  {
            ratingSum += r;
        }
        float averageRating = ratingSum / ratingCount;

        this.textViewAverageAllRating.setText("" + averageRating);

    }

    public void SuatClick(View view) {
        Intent in = new Intent(this,Activity_ChonGhe.class);

        startActivity(in);
    }

    /*private void initToobar(){
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    private void setmTablayout(){
        final CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsingToolbarLayout);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.a0);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int mColer=palette.getVibrantColor(getResources().getColor(R.color.colorPrimary));
                int mDarkColer=palette.getVibrantColor(getResources().getColor(R.color.back_trans));
                collapsingToolbarLayout.setContentScrimColor(mColer);
                collapsingToolbarLayout.setStatusBarScrimColor(mDarkColer);
            }
        });
    }*/
}