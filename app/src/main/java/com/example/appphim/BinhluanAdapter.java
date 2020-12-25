package com.example.appphim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appphim.commentUser;

import java.util.List;

public class BinhluanAdapter extends RecyclerView.Adapter<BinhluanAdapter.CommentViewHoder>{

    private List<commentUser> mListComment;

    public void commentData(List<commentUser> list){
        this.mListComment=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CommentViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_comment,parent,false);
        return new CommentViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHoder holder, int position) {

        commentUser cm=mListComment.get(position);
        if(cm==null){
            return;
        }
        holder.commetAVT.setImageResource(cm.getUserId());
        holder.userName.setText(cm.getUserName());
        holder.userCM.setText(cm.getUserComment());
    }

    @Override
    public int getItemCount() {
        if(mListComment!=null){
            return mListComment.size();
        }
        return 0;
    }

    public class CommentViewHoder extends RecyclerView.ViewHolder{

        private ImageView commetAVT;
        private TextView userName;
        private TextView userCM;
        public CommentViewHoder(@NonNull View itemView) {
            super(itemView);

            commetAVT=itemView.findViewById(R.id.userAvata);
            userName=itemView.findViewById(R.id.userName);
            userCM=itemView.findViewById(R.id.userComment);
        }
    }
}
