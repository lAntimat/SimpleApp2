package com.example.simpleapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new NewsAdapter(this, generateFakeNews());
        adapter.setOnClickListener(new OnNewsClickListener() {
            @Override
            public void onItemClick(News news) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("title", news.getNewsTitle());

                startActivity(intent);
            }
        });


        recyclerView.setAdapter(adapter);


    }

    private ArrayList<News> generateFakeNews() {

        ArrayList<News> newsList = new ArrayList<News>();

        for (int i = 0; i < 100; i++) {
            News news = new News("Hot news " + i, "hothothothtothot");
            newsList.add(news);
        }

        return newsList;
    }
}