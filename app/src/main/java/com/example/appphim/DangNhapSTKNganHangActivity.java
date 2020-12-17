package com.example.appphim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DangNhapSTKNganHangActivity extends AppCompatActivity {
    private Button btnTroLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_s_t_k_ngan_hang);

        btnTroLai = (Button)findViewById(R.id.btnTroLai);
        btnTroLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapSTKNganHangActivity.this,ChonNganHangActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}