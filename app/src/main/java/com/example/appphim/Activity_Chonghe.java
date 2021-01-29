package com.example.appphim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Activity_ChonGhe extends AppCompatActivity {

    private static List<Seat_Info> dsGHE;
    private RecyclerView rcvDsghe;
    private FilmTicket ve;
    private List<Integer> gheID;
    public List<gheClass>  mghe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__chon_ghe);

        rcvDsghe=findViewById(R.id.dsGHE);
        Intent intent = this.getIntent();

        ve=setTTPhim(intent);
        gheID=new ArrayList<>();
        mghe=new ArrayList<>();
        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là ThongTinLichChieu)
        Moshi moshi = new Moshi.Builder().build();


        Type ghe = Types.newParameterizedType(List.class,gheClass.class);
        final JsonAdapter<List<gheClass>> jsonAdapter = moshi.adapter(ghe);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://192.168.1.9/api/GheAPI.json")
                .build();
        // Thực thi request lấy các ghế đã đặt
        client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("Error", "Network Error or Syntax wrong");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String json = response.body().string();
                    final List<gheClass> dsg = jsonAdapter.fromJson(json);
                    // Cho hiển thị lên RecyclerView.
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mghe=dsg;
                        }
                    });
                }
            });
        rcvDsghe.setLayoutManager(new GridLayoutManager(this, 7));
        TaoDSGHE();

        GheAdapter ga = new GheAdapter();
        ga.setDuLieu(dsGHE);
        rcvDsghe.setAdapter(ga);

    }

    public void GheClick(View view) {

        //Button btn = (Button)findViewById(view.getId());
        Button btn = (Button)view;
        Seat_Info g = (Seat_Info) btn.getTag();
        switch (g.getSeatStatus())
        {
            case 0:{
                btn.setBackgroundResource(R.color.red);
                g.setSeatStatus(1);
                btn.setTag(g);
                gheID.add(g.getSeatId());
                break;
            }
            case 1:{
                btn.setBackgroundResource(R.color.white);
                g.setSeatStatus(0);
                btn.setTag(g);
                for (Integer ig : gheID)
                {
                    if(ig == g.getSeatId())
                    {
                        gheID.remove(ig);break;
                    }
                }
                break;
            }
            default:break;
        }
    }

    public FilmTicket setTTPhim(Intent in)
    {
        FilmTicket fl = null;
        Bundle bundle = in.getExtras();
        if (bundle != null) {
            int idFilm = bundle.getInt("idphim", 0);
            int idPhong = bundle.getInt("idphong", 0);
            int idChiNhanh = bundle.getInt("idRap", 0);
            int idSuat = bundle.getInt("idSuat", 0);

            fl=new FilmTicket(idChiNhanh,idSuat,idFilm,idPhong,0,gheID,1);
        }
        return fl;
    }

    public void DatveClick(View view) {
        Intent datve = new Intent(this,MainActivityThanhToan.class);
        Bundle bundle = new Bundle();
        bundle.putInt("idchinhanh",ve.getCinemaID());
        bundle.putInt("idphong",ve.getPhongID());
        bundle.putInt("idphim",ve.getFilmID());
        bundle.putInt("idsuat",ve.getSuatID());
        int soghe = gheID.size();
        int[] dsgheid=new int[soghe];
        for (int i =0;i<soghe;i++)
        {
            dsgheid[i]=gheID.get(i);
        }
        bundle.putIntArray("dsgheid",dsgheid);
        datve.putExtras(bundle);
        startActivity(datve);
    }

    public void TaoDSGHE(){
        dsGHE = new ArrayList<>();
        for (int i=0;i<28;i++){
            Seat_Info g = new Seat_Info();
            g.setSeatId(i+1);
            g.setSeatStatus(0);
            for (gheClass ghe : mghe)
            {
                if(g.getSeatId()==ghe.gheid)
                    g.setSeatStatus(2);
            }
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