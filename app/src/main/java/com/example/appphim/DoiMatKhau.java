package com.example.appphim;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DoiMatKhau extends AppCompatActivity {
    private EditText mkcu, mkmoi, nlmk;
    private String url = "http://192.168.0.104:8000/WebQuanTri/public/api/doimatkhau";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
    }

    public void anhxa() {
        mkcu = (EditText) findViewById(R.id.editmkcu);
        mkmoi = (EditText) findViewById(R.id.editmkmoi);
        nlmk = (EditText) findViewById(R.id.editnlmk);

    }


    public void doimatkhau(View view) {
        anhxa();

//        Toast.makeText(getApplicationContext(),layemailtufile(),Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(),mkmoi.getText(),Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(),mkmoi.getText().toString(),Toast.LENGTH_LONG).show();
        if (checklogin()) {
            if (mkcu.getText().length() >= 6 && mkmoi.getText().length() >= 6 && nlmk.getText().length() >= 6) {

                if (nlmk.getText().toString().contentEquals(mkmoi.getText().toString())) {
                    RequestQueue queue = Volley.newRequestQueue(this);
                    StringRequest request = new StringRequest(Request.Method.POST,
                            url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.trim().equals("false")) {
                                Toast.makeText(getApplicationContext(), "Tài Khoản Lỗi hoặc Không Tồn Tại", Toast.LENGTH_LONG).show();
                            } else if (response.trim().equals("Passwordfalse")) {
                                Toast.makeText(getApplicationContext(), "Mật Khẩu Không Chính Xác", Toast.LENGTH_LONG).show();
                            } else {
                                ThanhVien KH = new ConvertJsontoObiect(getApplicationContext()).GET_JsonToModeThanhVien(response.toString(), nlmk.getText().toString());
                                luudulieudoimk(KH);
                                Toast.makeText(getApplicationContext(), "Đổi Mật Khẩu Thành Công!", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Lỗi Kết Nối", Toast.LENGTH_LONG).show();
                        }
                    }
                    ) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> param = new HashMap<>();
                            param.put("Email", layemailtufile());
                            param.put("MatKhau", mkcu.getText().toString());
                            param.put("MatKhaumoi", nlmk.getText().toString());
                            return param;
                        }
                    };
                    queue.add(request);
                } else {
                    Toast.makeText(getApplicationContext(), "Mật Khẩu Mới Không Trùng Khớp", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(getApplicationContext(), "= null", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Vui Lòng Đăng Nhập", Toast.LENGTH_LONG).show();
        }

    }

    public void luudulieudoimk(ThanhVien khachHang) {
        File file = new File(this.getExternalFilesDir(null), "TaiKhoanKH");
        Vector<ThanhVien> vector = new Vector<>();
        vector.add(khachHang);
        try {
            ObjectOutput objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            objectOutputStream.writeObject(vector);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String layemailtufile() {

        File file = new File(this.getExternalFilesDir(null), "TaiKhoanKH");
        Vector<ThanhVien> vector1 = new Vector<>();
        String emmail = null;
        try {
            ObjectInputStream ips = new ObjectInputStream(new FileInputStream(file));
            vector1 = (Vector<ThanhVien>) ips.readObject();
            ips.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (ThanhVien model_khachHang : vector1) {
            emmail = model_khachHang.getEmail();
        }
        return emmail;
    }

    public boolean checklogin() {
        if (layemailtufile().length() > 0) {
            return true;
        } else {
            return false;
        }
    }
}



