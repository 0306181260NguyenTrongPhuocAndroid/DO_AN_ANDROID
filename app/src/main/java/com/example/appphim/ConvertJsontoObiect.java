package com.example.appphim;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class ConvertJsontoObiect {
    private Context context;
    public ConvertJsontoObiect(Context context)
    {
        this.context=context;
    }
    public ThanhVien GET_JsonToModeThanhVien(String Json, String matkhau)
    {
        ThanhVien modelKhachHang = null;
        try {
            JSONObject root = new JSONObject(Json);
            modelKhachHang = new ThanhVien(root.getInt("id"),root.getString("hoten"),root.getString("mk"),root.getInt("gioitinh"),root.getInt("ngaysinh"),root.getString("email"),root.getString("sdt"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return modelKhachHang;
    }

}
