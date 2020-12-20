package com.example.appphim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class ChonNganHangActivity extends AppCompatActivity {
    private Button btnXacNhan;
    private RadioButton rad_SCB, rad_Agribank, rad_Viettinbank, rad_ACB, rad_Vietcombank,rad_BIDV,rad_OceanBank,
            rad_TPBank,rad_SHB;
    private TextView mgs;
    public static final String tenBank = "tenBank";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ngan_hang);

        rad_SCB = (RadioButton)findViewById(R.id.rad_SCB);
        rad_Agribank = (RadioButton)findViewById(R.id.rad_Agribank);
        rad_Viettinbank = (RadioButton)findViewById(R.id.rad_Viettinbank);
        rad_ACB = (RadioButton)findViewById(R.id.rad_ACB);
        rad_Vietcombank = (RadioButton)findViewById(R.id.rad_Vietcombank);
        rad_BIDV = (RadioButton)findViewById(R.id.rad_BIDV);
        rad_OceanBank = (RadioButton)findViewById(R.id.rad_Oceanbank);
        rad_TPBank = (RadioButton)findViewById(R.id.rad_TPBank);
        rad_SHB = (RadioButton)findViewById(R.id.rad_SHB);

        mgs = (TextView)findViewById(R.id.mgs);

        btnXacNhan = (Button)findViewById(R.id.btnXacNhan);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(rad_SCB.isChecked() == false && rad_Agribank.isChecked() == false && rad_Viettinbank.isChecked() == false &&
                        rad_Vietcombank.isChecked() == false && rad_BIDV.isChecked() == false && rad_OceanBank.isChecked() == false &&
                        rad_TPBank.isChecked() == false && rad_SHB.isChecked() == false && rad_ACB.isChecked() == false){
                    mgs.setText("Bạn chưa chọn ngân hàng");
                }

                if(rad_SCB.isChecked()){
                    Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                    intent.putExtra(tenBank,rad_SCB.getText().toString());
                    startActivity(intent);
                }

                if(rad_Agribank.isChecked()){
                    Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                    intent.putExtra(tenBank,rad_Agribank.getText().toString());
                    startActivity(intent);
                }

                if(rad_Viettinbank.isChecked()){
                    Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                    intent.putExtra(tenBank,rad_Viettinbank.getText().toString());
                    startActivity(intent);
                }

                if(rad_Vietcombank.isChecked()){
                    Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                    intent.putExtra(tenBank,rad_Vietcombank.getText().toString());
                    startActivity(intent);
                }

                if(rad_BIDV.isChecked()){
                    Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                    intent.putExtra(tenBank,rad_BIDV.getText().toString());
                    startActivity(intent);
                }

                if(rad_OceanBank.isChecked()){
                    Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                    intent.putExtra(tenBank,rad_OceanBank.getText().toString());
                    startActivity(intent);
                }

                if(rad_TPBank.isChecked()){
                    Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                    intent.putExtra(tenBank,rad_TPBank.getText().toString());
                    startActivity(intent);
                }

                if(rad_SHB.isChecked()){
                    Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                    intent.putExtra(tenBank,rad_SHB.getText().toString());
                    startActivity(intent);
                }

                if(rad_ACB.isChecked()){
                    Intent intent =new Intent(ChonNganHangActivity.this,DangNhapSTKNganHangActivity.class);
                    intent.putExtra(tenBank,rad_ACB.getText().toString());
                    startActivity(intent);
                }

            }
        });

        CompoundButton.OnCheckedChangeListener listenerRadio = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                btnXacNhan.setEnabled(true);
                if(isChecked){
                    mgs.setText("Bạn chọn: " + compoundButton.getText());
                }

            }
        };

        rad_SCB.setOnCheckedChangeListener(listenerRadio);
        rad_Agribank.setOnCheckedChangeListener(listenerRadio);
        rad_Viettinbank.setOnCheckedChangeListener(listenerRadio);
        rad_Vietcombank.setOnCheckedChangeListener(listenerRadio);
        rad_BIDV.setOnCheckedChangeListener(listenerRadio);
        rad_OceanBank.setOnCheckedChangeListener(listenerRadio);
        rad_TPBank.setOnCheckedChangeListener(listenerRadio);
        rad_ACB.setOnCheckedChangeListener(listenerRadio);
        rad_SHB.setOnCheckedChangeListener(listenerRadio);


    }

    public void truyenDuLieu(){
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