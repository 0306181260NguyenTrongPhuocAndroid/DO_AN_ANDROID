package com.example.appphim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class TrangCaNhanAdapter extends RecyclerView.Adapter<TrangCaNhanAdapter.ViewHolder> {
    private LinkedList<ThanhVien>mdata;
    private Context context;
    public TrangCaNhanAdapter(LinkedList<ThanhVien>mdata, Context context)
    {
        this.mdata=mdata;
        this.context=context;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
