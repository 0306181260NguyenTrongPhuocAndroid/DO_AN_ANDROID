package com.example.appphim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LichchieuAdapter  extends RecyclerView.Adapter<LichchieuAdapter.phimViewHolder>{
    @NonNull
    @Override
    public phimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lichchieu,parent,false);
        return new phimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull phimViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class phimViewHolder extends RecyclerView.ViewHolder{

        public phimViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
