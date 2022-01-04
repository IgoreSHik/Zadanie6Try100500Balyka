package com.example.zadanie6try100500balyka;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[];
    boolean data2[];
    Context context;

    public MyAdapter(Context ct, String s[]){
        context = ct;
        data1 = s;
    }

    public MyAdapter(Context ct, String s[], boolean b[]){
        context = ct;
        data1 = s;
        data2 = b;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText.setText(data1[position]);
        holder.checkBox.setChecked(data2[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText;
        //ConstraintLayout myLayout;
        LinearLayout myLayout;
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText = itemView.findViewById(R.id.task_name);
            checkBox = itemView.findViewById(R.id.task_done);
            myLayout = itemView.findViewById(R.id.linear_layout);
        }
    }
}