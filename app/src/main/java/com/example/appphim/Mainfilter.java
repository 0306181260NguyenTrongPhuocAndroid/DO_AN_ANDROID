package com.example.appphim;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.appphim.R.layout.activity_mainfilter;

public class Mainfilter extends AppCompatActivity {
    Button btndangChieu;
    Button btnsapChieu;

    Button selectDangchieu;
    Button selectSapchieu;
    final List<Phim> dangchieu_ats = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_mainfilter);
        selectDangchieu = findViewById(R.id.btn_dsdc);
        selectSapchieu = findViewById(R.id.btn_dssc);

        initslider1(dangchieu_ats);
        btndangChieu = (Button) findViewById(R.id.dsdangchieu);
        btnsapChieu = (Button) findViewById(R.id.dssapchieu);

        btndangChieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initslider(dangchieu_ats);

                select(v);
            }
        });
        btnsapChieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initslider1(dangchieu_ats);
                select(v);
            }
        });

    }
    @SuppressLint("ResourceAsColor")
    public void select(View view) {

        switch (view.getId()) {
            case R.id.dsdangchieu: {
                selectDangchieu.setBackgroundResource(R.color.selected_tab);
                selectSapchieu.setBackgroundResource(R.color.nonselected_tab);
            }
            break;
            case R.id.dssapchieu: {
                selectDangchieu.setBackgroundResource(R.color.nonselected_tab);
                selectSapchieu.setBackgroundResource(R.color.selected_tab);
            }
            break;
        }
    }
    public void initslider1(List<Phim> dangchieus) {
        final RecyclerView rvUsers = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.rv_users);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, Phim.class);
        final JsonAdapter<List<Phim>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://10.10.3.174:8000/api5sapchieu")
                .build();

        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String json = response.body().string();
                final List<Phim> users = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvUsers.setAdapter(new timkiemAdapter(users, Mainfilter.this));
                    }
                });
            }

        });
    }
    public void initslider(List<Phim> dangchieus) {
        final RecyclerView rvUsers = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.rv_users);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, Phim.class);
        final JsonAdapter<List<Phim>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://10.10.3.174:8000/api5dangchieu")
                .build();

        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String json = response.body().string();
                final List<Phim> users = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvUsers.setAdapter(new timkiemAdapter(users, Mainfilter.this));
                    }
                });
            }

        });
    }

}
