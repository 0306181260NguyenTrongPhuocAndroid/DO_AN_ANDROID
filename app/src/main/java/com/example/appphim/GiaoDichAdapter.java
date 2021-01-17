package com.example.appphim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class GiaoDichAdapter extends RecyclerView.Adapter<GiaoDichAdapter.ViewHolder> {
    private  LinkedList<GiaoDich>mdata;
    private  Context context;
    public GiaoDichAdapter(LinkedList<GiaoDich> mdata, Context context)
    {
        this.mdata=mdata;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_giaodich,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.giave.setText(mdata.get(position).getGiave());
        holder.NgayChieu.setText(mdata.get(position).getNgayDat());
        holder.tenphim.setText(mdata.get(position).getTenPhim());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView sl;
        private  TextView giave;
        private TextView NgayChieu;
        private  TextView tenphim;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            giave=itemView.findViewById(R.id.txtGiaVe);
            NgayChieu=itemView.findViewById(R.id.txtNgayDat);
            tenphim=itemView.findViewById(R.id.txtTenPhim);
        }

    }


}
