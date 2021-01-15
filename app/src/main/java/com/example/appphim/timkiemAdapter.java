package com.example.appphim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class timkiemAdapter extends RecyclerView.Adapter<timkiemAdapter.PhimHolder>{
private List<Phim> dsphim;
private Context context;
public timkiemAdapter(List<Phim> dsphim, Context c) {
        this.dsphim = dsphim;
        this.context = c;
        }
@NonNull
@Override

public PhimHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.worditem, parent, false);

        return new PhimHolder(itemView);
        }

@Override
public void onBindViewHolder(@NonNull PhimHolder holder, int position) {
        Phim u = dsphim.get(position);
        Picasso.with(context)
        .load(u.hinhanh)
        .into(holder.hinhanh);
        holder.txttenphim.setText(u.tenphim);
        holder.txttheloai.setText(String.valueOf(u.theloai_id));
        holder.txtnoidungphim.setText(u.noidungphim);
        holder.diemphim.setText(u.diemphim);
        }

@Override
public int getItemCount() {
        return dsphim.size();
        }

public class PhimHolder extends RecyclerView.ViewHolder {
    public TextView txttenphim;
    public TextView txtnoidungphim;
    public TextView diemphim;
    public ImageView hinhanh; public TextView txttheloai;

    public PhimHolder(@NonNull View itemView) {
        super(itemView);
        txttenphim = (TextView) itemView.findViewById(R.id.name);
        txttheloai = (TextView) itemView.findViewById(R.id.theloai);
        txtnoidungphim=(TextView) itemView.findViewById(R.id.ndphim);
        diemphim=(TextView) itemView.findViewById(R.id.diemphim);
        hinhanh = (ImageView) itemView.findViewById(R.id.img);


    }
}
}