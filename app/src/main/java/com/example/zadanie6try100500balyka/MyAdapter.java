package com.example.zadanie6try100500balyka;

import android.content.Context;
import android.content.Intent;
import android.hardware.TriggerEventListener;
import android.location.GnssAntennaInfo;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[];
    boolean data2[];
    Context context;
    int itemCount;
    Button button_newTask;

    public MyAdapter(Context ct, String s[], boolean b[], Button button){
        context = ct;
        data1 = s;
        data2 = b;
        itemCount = 5;
        button_newTask = button;
        button_newTask.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCount++;
                TasksLeftCount();
            }
        });
    }

    public void TasksLeftCount() {
        int tasksLeftCounter = 0;
        for (int i = 0; i < itemCount; i++)
            if (!data2[i]) tasksLeftCounter++;
        MainActivity.setTasksLeftCounter(tasksLeftCounter);
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
        if (data2[position]) {
            holder.imageView_undone.setVisibility(View.INVISIBLE);
            holder.imageView_done.setVisibility(View.VISIBLE);
        } else {
            holder.imageView_undone.setVisibility(View.VISIBLE);
            holder.imageView_done.setVisibility(View.INVISIBLE);
        }
        holder.checkBox.setOnClickListener(new CompoundButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.checkBox.isChecked()) {
                    holder.imageView_undone.setVisibility(View.INVISIBLE);
                    holder.imageView_done.setVisibility(View.VISIBLE);
                    data2[position] = true;
                } else {
                    holder.imageView_undone.setVisibility(View.VISIBLE);
                    holder.imageView_done.setVisibility(View.INVISIBLE);
                    data2[position] = false;
                }
                TasksLeftCount();
            }
        });
        if (position<itemCount) {holder.myLayout.setVisibility(View.VISIBLE);}
        else {holder.myLayout.setVisibility(View.INVISIBLE);}
    }

    @Override
    public void onViewRecycled(@NonNull MyViewHolder holder) {
        super.onViewRecycled(holder);
        int position = holder.getAdapterPosition();
        data1[position] = holder.myText.getText().toString();
        data2[position] = holder.checkBox.isChecked();
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText;
        //ConstraintLayout myLayout;
        ConstraintLayout myLayout;
        CheckBox checkBox;
        ImageView imageView_done, imageView_undone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText = itemView.findViewById(R.id.task_name);
            checkBox = itemView.findViewById(R.id.task_done);
            myLayout = itemView.findViewById(R.id.linear_layout);
            imageView_done = itemView.findViewById(R.id.imageView_done);
            imageView_undone = itemView.findViewById(R.id.imageView_undone);
            TasksLeftCount();
        }
    }
}