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
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivityChitiet extends AppCompatActivity {
    private ImageView image;
    private int id;
    public List<LichChieuClass> dsLC;
    public List<commentUser> dsCmt;
    public chitiet_phim phim;
    public String linkLCApi;
    public String linkSCApi;

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
        dsLC=new ArrayList<>();
        //dsSC = new ArrayList<>();
        linkLCApi="http://192.168.1.9/api/LCapi.json";
        linkSCApi="http://192.168.1.9/api/SCapi.json";
        //"https://api.github.com/users"

        Intent intent=this.getIntent();
        phim = getDataFilm(intent);

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là ThongTinLichChieu)
        Moshi moshi = new Moshi.Builder().build();


        Type lcphim = Types.newParameterizedType(List.class,LichChieuClass.class);
        final JsonAdapter<List<LichChieuClass>> jsonAdapter = moshi.adapter(lcphim);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://192.168.1.9/api/LCapi.json")
                .build();
        // Thực thi request lấy các rạp chiếu của phim
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error or Syntax wrong");
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String json = response.body().string();
                final List<LichChieuClass> dslc = jsonAdapter.fromJson(json);
                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(dslc.size()>0){
                            for (LichChieuClass lc : dslc) {
                                //Tạo thông tin cho Item RecyclerView
                                LichChieuClass tt = new LichChieuClass();
                                tt.CinemaID=lc.CinemaID;
                                tt.CinemaName=lc.CinemaName;
                                tt.RoomId=lc.RoomId;
                                tt.phimID=lc.phimID;
                                tt.gioBatDau=lc.gioBatDau;
                                tt.ngayChieu=lc.ngayChieu;
                                tt.suatChieuID=lc.suatChieuID;
                                tt.trangThai=lc.trangThai;

                                dsLC.add(tt);
                            }
                        }

                    }
                });
            }
        });

//      ArrayList<dangchieu_AT> list = (ArrayList<dangchieu_AT>) intent.getSerializableExtra("list");

        mTablayout = findViewById(R.id.DetailsTablayout);
        mViewPager=findViewById(R.id.Detailsviewpager);

        mViewpagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        mViewPager.setAdapter(mViewpagerAdapter);

        mTablayout.setupWithViewPager(mViewPager);

        //mViewPager.beginFakeDrag();


        this.ratingBarYours = (RatingBar) this.findViewById(R.id.ratingBar_yours);
        this.textViewAverageAllRating= (TextView) this.findViewById(R.id.Diem);
        //setmTablayout();
        /*List<ThongTinLichChieu> t = Data();

        Gson gson = new Gson();
        String strgson = gson.toJson(t);
        Log.e("String Json",strgson);*/



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

    /*

    private void initToobar(){
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


for (final ThongTinLichChieu ttlc : dsttlc) {
            OkHttpClient mclient = new OkHttpClient();
            Moshi mmoshi = new Moshi.Builder().build();
            Type msc = Types.newParameterizedType(List.class, SuatChieuClass.class);
            final JsonAdapter<List<SuatChieuClass>> jsad = mmoshi.adapter(msc);
            Request mrequest = new Request.Builder()
                    .url("http://192.168.1.9/api/SCapi.json")
                    .build();

            // Thực thi request.
            mclient.newCall(mrequest).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("Error", "Network Error or Syntax wrong");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String js = response.body().string();
                    final List<SuatChieuClass> dssc = jsad.fromJson(js);

                    // Cho hiển thị lên RecyclerView.
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(dssc.size()>0)
                            {
                                List<SuatChieu> sc = new ArrayList<>();
                                for(SuatChieuClass l : dssc)
                                {
                                    SuatChieu msc = new SuatChieu();
                                    msc.suatChieuID=l.suatChieuID;
                                    msc.gioBatDau=l.gioBatDau;
                                    msc.trangThai=l.trangThai;
                                    sc.add(msc);
                                }
                                ttlc.setDsSuatChieu(sc);
                            }
                        }
                    });
                }

                private void runOnUiThread(Runnable runnable) {
                }
            });
        }
    }*/
    /*public List<ThongTinLichChieu> Data(){
        List<ThongTinLichChieu> LC = new ArrayList<>();

        for (int i = 0; i<4;i++)
        {
            ThongTinLichChieu l = new ThongTinLichChieu();
            l.setCinemaName("Lê Quý Đôn");
            //l.setNgayChieu(new Date(2021,1,4));
            l.setRoomId(1);
            LinkedList<SuatChieu> sc = new LinkedList<SuatChieu>();
            for (int j = 0;j<i+3;j++)
            {
                SuatChieu s = new SuatChieu(j+1,new Date(2021,1,4),(j+1)*2,1);
                sc.add(s);
            }
            l.setDsSuatChieu(sc);
            LC.add(l);
        }
        return LC;
    }*/
}
