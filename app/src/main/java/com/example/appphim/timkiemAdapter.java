package com.example.appphim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class timkiemAdapter extends RecyclerView.Adapter<timkiemAdapter.phimHolder> {
    Context context;
    List<Phim> danhsach;
    public  timkiemAdapter(Context context,List<Phim> danhsach)
    {
        this.context = context;
        this.danhsach = danhsach;
    }
    @NonNull
    @Override
    public phimHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater= LayoutInflater.from(context);
        View view=mInflater.inflate(R.layout.worditem,parent,false);
        return new phimHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull timkiemAdapter.phimHolder holder, int position) {
        holder.txtTen.setText(danhsach.get(position).getName());
        holder.txtTuoi.setText(danhsach.get(position).getTuoi());
        holder.txtTheLoai.setText(danhsach.get(position).getTheloai());
        holder.txtDiem.setText(danhsach.get(position).getDiem());
        holder.img.setImageResource(danhsach.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return danhsach.size();
    }

    public class phimHolder extends RecyclerView.ViewHolder {
        TextView txtdotuoi;
        TextView txtTen;
        TextView txtTuoi;
        TextView txtDiem;
        TextView txtTheLoai;
        ImageButton img;
        public phimHolder(@NonNull View itemView) {
            super(itemView);
            txtTen=(TextView)itemView.findViewById(R.id.name);
            txtTuoi=(TextView)itemView.findViewById(R.id.đotuoi);
            txtTheLoai=(TextView)itemView.findViewById(R.id.theloai);
            txtDiem=(TextView)itemView.findViewById(R.id.diem);
            img=(ImageButton)itemView.findViewById(R.id.img);

        }
    }
}