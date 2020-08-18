package com.example.moviesone;


import com.example.moviesone.utils.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.moviesone.model.Movie;
import com.example.moviesone.utils.JsonUtils;
import com.example.moviesone.utils.URLJson;
import com.squareup.picasso.Picasso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONException;

import java.io.ObjectInputStream;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button button;
    MyRecyclerViewAdapter adapter;
//    int mData[] = new int[] {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6};  **

    String[] mData = new String[]{"https://i.imgur.com/DvpvklR.png", "https://i.imgur.com/DvpvklR.png", "https://i.imgur.com/DvpvklR.png"};

    String mDatafake = "";

    // parse the data and
     // Movie mData = new Movie[];
      URLJson urlJson;
      boolean flip = true;

   // String[] mData = new String[]{"https://api.themoviedb.org/3/movie/top_rated?api_key=4fffd63b70b5220ca4f07dd0add06a45"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        GridLayoutManager gridLayout = new GridLayoutManager(this, 3);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(gridLayout);

        try {
            urlJson = new URLJson();
            urlJson.execute("https://api.themoviedb.org/3/movie/top_rated?api_key=4fffd63b70b5220ca4f07dd0add06a45").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            String s = null;
            public void onClick(View v) {

                try {

                    if (flip) {
                        urlJson.execute("http://api.themoviedb.org/3/movie/popular?api_key=4fffd63b70b5220ca4f07dd0add06a45").get();
                        flip = false;
                    }else {
                        urlJson.execute("https://api.themoviedb.org/3/movie/top_rated?api_key=4fffd63b70b5220ca4f07dd0add06a45").get();
                        flip = true;
                    }

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("s: " + s);
            }
        });

        Movie[] movies = null;
        Movie[] mData;
        System.out.println("out");
        try {
            movies = JsonUtils.parseMovieJson(urlJson.getString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        mData = movies;

        adapter = new MyRecyclerViewAdapter(this, mData);

        recyclerView.setAdapter(adapter);

    }

}
