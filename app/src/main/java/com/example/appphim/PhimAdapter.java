package com.example.appphim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhimAdapter extends RecyclerView.Adapter<com.example.appphim.PhimAdapter.UserViewHolder>{

    private List<com.example.appphim.chitiet_phim> mListUser;
    public void setData(List<com.example.appphim.chitiet_phim> list){
        this.mListUser=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_film_details,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        com.example.appphim.chitiet_phim user=mListUser.get(position);
        if(user==null){
            return;
        }
        holder.hinhphim.setImageResource(user.getId());
        holder.tenPhim.setText(user.getTenPhim());
        holder.soDiem.setText(user.getSoDiem());
        holder.doTuoi.setText(user.getDoTuoi());
        holder.theLoai.setText(user.getTheLoai());
        holder.moTa.setText(user.getMoTa());
        holder.trailer.setText(user.getTrailer());
    }

    @Override
    public int getItemCount() {
        if(mListUser!=null){
            return mListUser.size();
        }
        return 0;
    }


    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView hinhphim;
        private TextView tenPhim;
        private TextView soDiem;
        private TextView doTuoi;
        private TextView theLoai;
        private TextView moTa;
        private TextView trailer;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            hinhphim=(itemView).findViewById(R.id.hinhPhim);
            tenPhim=itemView.findViewById(R.id.tenPhim);
            doTuoi=itemView.findViewById(R.id.doTuoi);
            soDiem=itemView.findViewById(R.id.soDiem);
            theLoai=itemView.findViewById(R.id.theLoai);
            moTa=itemView.findViewById(R.id.mota);
            trailer=itemView.findViewById(R.id.traler);
        }
    }


}
