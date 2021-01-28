package com.example.appphim;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.List;

public class AdapterTrangChinh extends RecyclerView.Adapter<AdapterTrangChinh.PhimHolder>{
    private List<dangchieu_AT> dangchieu_ats;
    private Context context;

    public AdapterTrangChinh(List<dangchieu_AT> dangchieu_ats, Context context) {
        this.dangchieu_ats = dangchieu_ats;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public PhimHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slide_dang_chieu, parent, false);

        return new AdapterTrangChinh.PhimHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhimHolder holder, final int position) {
        dangchieu_AT dangchieu_at = dangchieu_ats.get(position);
        holder.txttenphim.setText(dangchieu_at.tenphim);
        holder.diemphim.setText(dangchieu_at.diemphim);
        holder.txtloaiphim.setText(dangchieu_at.theloai_id);
        Picasso.with(context)
                .load(dangchieu_at.hinhanh)
                .into(holder.hinhanh);
        holder.hinhanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,MainActivityChitiet.class);
                intent.putExtra("id",position);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dangchieu_ats.size();
    }

    public class PhimHolder extends RecyclerView.ViewHolder {
        public TextView txttenphim;
        public TextView txtloaiphim;
        public TextView diemphim;
        public ImageView hinhanh;


        public PhimHolder(@NonNull View itemView) {
            super(itemView);
            txttenphim = (TextView) itemView.findViewById(R.id.title);
            txtloaiphim=(TextView) itemView.findViewById(R.id.desc);
            diemphim=(TextView) itemView.findViewById(R.id.txtDiem);
            hinhanh = (ImageView) itemView.findViewById(R.id.imageSlide);
        }
    }
}
