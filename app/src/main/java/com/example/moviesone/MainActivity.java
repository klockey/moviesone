package com.example.moviesone;


import com.example.moviesone.utils.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.moviesone.model.Movie;
import com.example.moviesone.utils.JsonUtils;
//import com.example.moviesone.utils.URLJson;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button button;
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    Movie[] mData;
    boolean flip = true;
   // final MainActivity.URLJson urlJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayoutManager gridLayout = new GridLayoutManager(this, 3);

        recyclerView = (RecyclerView) findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(gridLayout);

        final MainActivity mainActivity = new MainActivity();

      //  final MainActivity.URLJson urlJson = mainActivity.new URLJson();

        System.out.println("execute");



        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            String s = null;
            public void onClick(View v) {
              if (flip){
                  mainActivity.new URLJson().execute("https://api.themoviedb.org/3/movie/popular?api_key=4fffd63b70b5220ca4f07dd0add06a45");
              } else {
                  mainActivity.new URLJson().execute("https://api.themoviedb.org/3/movie/top_rated?api_key=4fffd63b70b5220ca4f07dd0add06a45");
              }
            }
        });

        mainActivity.new URLJson().execute("https://api.themoviedb.org/3/movie/top_rated?api_key=4fffd63b70b5220ca4f07dd0add06a45","no");
    }

    private void setupAdapter() {
        adapter = new MyRecyclerViewAdapter(this, mData);

        recyclerView.setAdapter(adapter);
    }

    private class URLJson extends AsyncTask<String, String, String> {
        public String json = "";
        public String string;
        Context context;

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... s) {
            try {
                System.out.println("do");
                StringBuffer response;
                URL obj = new URL(s[0]);
                HttpURLConnection con = null;
                if (Network.isOnline()) {
                    con = (HttpURLConnection) obj.openConnection();

                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    json = response.toString();

                    if (s[1].equals("no"))
                        json = null;

               }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(json);

            return json;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                System.out.println("on post" + s);

                if (s != null) {
                    mData = JsonUtils.parseMovieJson(s);
                    setupAdapter();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(String... text) {

        }
    }
}


