package com.example.appphim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class GheAdapter extends RecyclerView.Adapter<GheAdapter.GheViewHolder>{
    private LinkedList<Seat_Info> dsGhe;

    public void setDuLieu(LinkedList<Seat_Info> dsg)
    {
        dsGhe=dsg;
    }
    @NonNull
    @Override
    public GheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ghe,parent,false);
        return new GheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GheViewHolder holder, int position) {
        Seat_Info g = dsGhe.get(position);
        if(g == null)
            return;
        holder.IconGhe.setText(""+g.getSeatName());
        holder.IconGhe.setTag(g.getSeatStatus());
        switch (g.getSeatStatus())
        {
            case 0:{
                holder.IconGhe.setBackgroundResource(R.color.white); break;
            }
            case 1:{
                holder.IconGhe.setBackgroundResource(R.color.red); break;
            }
            default:{
                holder.IconGhe.setBackgroundResource(R.color.seat_selected);
                holder.IconGhe.setEnabled(false);
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if(dsGhe == null)
            return 0;
        else
            return dsGhe.size();
    }

    public class GheViewHolder extends RecyclerView.ViewHolder {


        private Button IconGhe;

        public GheViewHolder(@NonNull View itemView) {
            super(itemView);
            IconGhe =itemView.findViewById(R.id.iconGhe);
        }
    }
}
