package com.example.zadanie6try100500balyka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button_newTask;
    public static TextView tasksLeftCounter;

    public static void setTasksLeftCounter(int x)
    {
        tasksLeftCounter.setText(Integer.toString(x));
    }

    String s1[], s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        button_newTask = findViewById(R.id.button_newTask);

        TaskStorage taskStorage = TaskStorage.takeTaskStorage();

        //MyAdapter myAdapter = new MyAdapter(this, s1, s2);
        MyAdapter myAdapter = new MyAdapter(this, TaskStorage.getNames(), TaskStorage.getIsDone(), button_newTask);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksLeftCounter = findViewById(R.id.tasks_left_counter);
    }
}