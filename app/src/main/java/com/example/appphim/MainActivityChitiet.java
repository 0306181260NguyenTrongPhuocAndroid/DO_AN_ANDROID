package com.example.appphim;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
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
    public List<ThongTinLichChieu> dsLC;
    public List<commentUser> dsCmt;
    public chitiet_phim phim;

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
        Intent intent=this.getIntent();
        phim = getDataFilm(intent);
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

    public chitiet_phim getDataFilm(Intent in)
    {
        chitiet_phim f= null;
        Bundle bundle = in.getExtras();
        if (bundle != null) {
            int id = bundle.getInt("Key_1");
            String ten = bundle.getString("Key_2", "");
            String diem = bundle.getString("Key_3", "");
            String dotuoi = bundle.getString("Key_4", "");
            String theloai = bundle.getString("Key_5", "");
            String mota = bundle.getString("Key_6", "");
            //String img = bundle.getString("Key_7", "");
            f = new chitiet_phim(id,ten,diem,dotuoi,theloai,mota,"");
        }
        return f;
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
        FragmentClass fragInfo = new FragmentClass();
fragInfo.setArguments(bundle);
transaction.replace(R.id.fragment_single, fragInfo);
transaction.commit();
    }*/
}