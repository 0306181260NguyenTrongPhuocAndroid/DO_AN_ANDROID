package com.example.appphim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DangNhapSTKNganHangActivity extends AppCompatActivity {
    private Button btnTroLai,btnDangNhap;
    private TextView bankDuocChon;
    private EditText stk , matKhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_s_t_k_ngan_hang);

        bankDuocChon = (TextView)findViewById(R.id.bankDuocChon);
        Intent intent = getIntent();
        String tenBankChon = intent.getStringExtra(ChonNganHangActivity.tenBank);
        bankDuocChon.setText(tenBankChon);

        btnTroLai = (Button)findViewById(R.id.btnTroLai);
        btnTroLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapSTKNganHangActivity.this,ChonNganHangActivity.class);
                startActivity(intent);
                finish();
            }
        });

        stk = (EditText)findViewById(R.id.txtSTK);
        matKhau = (EditText)findViewById(R.id.txtMatKhau);

        InputStream inputStream = getApplication().getResources().openRawResource(R.raw.infosotaikhoan);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String json;

        while(true){
            try{
                if((line = bufferedReader.readLine())==null)break;
            }
            catch (IOException e){
                e.printStackTrace();
            }
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }

        json = stringBuilder.toString();
        try{
            JSONObject jsonRoot = new JSONObject(json);
            JSONObject ob = jsonRoot.getJSONObject("infodangnhap");
            stk.setText(ob.getString("stk"));
            matKhau.setText(ob.getString("pass"));

        }
        catch (JSONException e){
            e.printStackTrace();
        }


        final String sotaikhoan = "1234567890111213";
        final String password = "admin";
        final String NULL = "";

        btnDangNhap = (Button)findViewById(R.id.btnDangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stk.getText().toString().equals(NULL)){
                    stk.setHint("STK k đc trống");
                    stk.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
                }

                if(matKhau.getText().toString().equals(NULL)){
                    matKhau.setHint("Mật khẩu k đc trống");
                    matKhau.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
                }
                else
                {
                    if(matKhau.getText().length() <= 4){
                        matKhau.setText("");
                        matKhau.setHint("có từ 5 ký tự trở lên");
                        matKhau.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
                    }
                }

                if(stk.getText().toString().equals(sotaikhoan) && matKhau.getText().toString().equals(password)){
                    Toast.makeText(getApplicationContext(),"Thanh toán thành công",Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(this,DangNhapThanhCong.class);
                    //startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Thanh toán thất bại", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}