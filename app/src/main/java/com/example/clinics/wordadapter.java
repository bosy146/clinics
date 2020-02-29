package com.example.clinics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class wordadapter extends RecyclerView.Adapter<wordadapter.WordViewHolder> {
    public ArrayList<wordclass> mArrayList;
    public static class WordViewHolder extends RecyclerView.ViewHolder
    {

        public ImageView mImageView;
        public TextView mTextView;
        public TextView mTextView2;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageView);
            mTextView=itemView.findViewById(R.id.text1);
            mTextView2=itemView.findViewById(R.id.text2);
        }
    }
    public wordadapter (ArrayList<wordclass>list)
    {
        mArrayList=list;

    }
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        WordViewHolder wordViewHolder=new WordViewHolder(v);
        return wordViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        wordclass currenItem = mArrayList.get(position);
        //pass values

        holder.mImageView.setImageResource(currenItem.getmImageView());
        holder.mTextView.setText(currenItem.getmTextV1());
        holder.mTextView2.setText(currenItem.getmTextV2());

    }
    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}
