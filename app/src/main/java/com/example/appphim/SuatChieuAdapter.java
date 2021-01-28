package com.example.appphim;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.zip.Inflater;

public class SuatChieuAdapter extends RecyclerView.Adapter<SuatChieuAdapter.SuatChieuViewHolder>{

    private int PhongID;
    private int PhimID;
    private int Cinema;
    private Context context;
    private LinkedList<SuatChieu> dsSuat;

    public void setDataSuatChieu(LinkedList<SuatChieu> listSuat){
        this.dsSuat = listSuat;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SuatChieuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_suatchieu,parent,false);
        return new SuatChieuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuatChieuViewHolder holder, int position) {
        SuatChieu suat = dsSuat.get(position);

        holder.btnsuatchieu.setText(suat.gioBatDau+":00");
    }

    @Override
    public int getItemCount() {
        if (dsSuat==null)
            return 0;
        return dsSuat.size();
    }

    public class SuatChieuViewHolder extends RecyclerView.ViewHolder{
        public Button btnsuatchieu;

        public SuatChieuViewHolder(@NonNull View itemView) {
            super(itemView);
            btnsuatchieu = itemView.findViewById(R.id.btn_suatchieu);
        }
    }
}
