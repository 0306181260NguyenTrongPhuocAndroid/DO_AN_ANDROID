package com.example.appphim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class LichchieuAdapter extends RecyclerView.Adapter<LichchieuAdapter.phimViewHolder>{
    private LinkedList<ThongTinLichChieu> dsLichChieu;
    public Context context;

    public void setDataLichChieu(LinkedList<ThongTinLichChieu> list,Context context)
    {
        this.dsLichChieu = list;
        this.context=context;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public phimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lichchieu,parent,false);
        return new phimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull phimViewHolder holder, int position) {
        ThongTinLichChieu mlichchieu = dsLichChieu.get(position);

        holder.cinemaName.setText(mlichchieu.getCinemaName());

        holder.dsSuatChieu.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        SuatChieuAdapter msca= new SuatChieuAdapter();
        msca.setDataSuatChieu(mlichchieu.getDsSuatChieu());
        holder.dsSuatChieu.setAdapter(msca);
    }

    @Override
    public int getItemCount() {
        if(dsLichChieu==null)
            return 0;
        return dsLichChieu.size();
    }

    public class phimViewHolder extends RecyclerView.ViewHolder{

        public TextView cinemaName;
        public RecyclerView dsSuatChieu;
        public phimViewHolder(@NonNull View itemView) {
            super(itemView);

            cinemaName = itemView.findViewById(R.id.tenRap);
            dsSuatChieu = itemView.findViewById(R.id.dsSuatChieuFilm);
        }
    }
}
