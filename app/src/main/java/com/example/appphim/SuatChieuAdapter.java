package com.example.appphim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.zip.Inflater;

public class SuatChieuAdapter extends RecyclerView.Adapter<SuatChieuAdapter.SuatChieuViewHolder>{

    private LinkedList<SuatChieu> dsSuat;

    public void setDataSuatChieu(LinkedList<SuatChieu> listSuat){
        this.dsSuat = listSuat;
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

    public class SuatChieuViewHolder extends RecyclerView.ViewHolder {
        public Button btnsuatchieu;
        public SuatChieuViewHolder(@NonNull View itemView) {
            super(itemView);
            btnsuatchieu = itemView.findViewById(R.id.btn_suatchieu);
        }
    }
}
