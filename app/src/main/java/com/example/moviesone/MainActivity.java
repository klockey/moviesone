package com.example.moviesone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import java.io.ObjectInputStream;

public class MainActivity extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;
//    int mData[] = new int[] {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6};  **

    String[] mData = new String[]{"https://i.imgur.com/DvpvklR.png", "https://i.imgur.com/DvpvklR.png", "https://i.imgur.com/DvpvklR.png"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayoutManager gridLayout = new GridLayoutManager(this, 3);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(gridLayout);

        adapter = new MyRecyclerViewAdapter(this, mData);

        recyclerView.setAdapter(adapter);
    }
}
