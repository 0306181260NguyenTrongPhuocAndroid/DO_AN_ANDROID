package com.example.appphim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChonNganHangActivity extends AppCompatActivity {
    private Button btnXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ngan_hang);

        btnXacNhan = (Button)findViewById(R.id.btnXacNhan);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                startActivity(intent);

            }
        });
    }
}