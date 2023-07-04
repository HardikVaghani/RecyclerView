package com.app.hardik.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> data = new ArrayList<>();
        // Add data to the list
        data.add("Item 1");
        data.add("Item 2");
        data.add("Item 3");
        data.add("Item 4");
        data.add("Item 5");
        data.add("Item 6");
        data.add("Item 7");
        data.add("Item 8");
        data.add("Item 9");
        data.add("Item 10");
        data.add("Item 11");
        data.add("Item 12");
        data.add("Item 13");
        data.add("Item 14");
        data.add("Item 15");

        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}