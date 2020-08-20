package com.example.moviesone;

import com.example.moviesone.utils.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moviesone.model.Movie;
import com.example.moviesone.utils.JsonUtils;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    Button button;
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    Movie[] mData;
    boolean flip = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayoutManager gridLayout = new GridLayoutManager(this, 3);

        recyclerView = (RecyclerView) findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(gridLayout);

        callAsync("https://api.themoviedb.org/3/movie/top_rated?api_key=");

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            String s = null;
            public void onClick(View v) {
              if (flip){
                    callAsync("https://api.themoviedb.org/3/movie/popular?api_key=");
                    flip = false;
              } else {
                    callAsync("https://api.themoviedb.org/3/movie/top_rated?api_key=");
                    flip = true;
              }
            }
        });
    }

    void callAsync(String s) {
        new URLJson(this).execute(s);
    }

    void setupAdapter() {
        adapter = new MyRecyclerViewAdapter(this, mData);
        recyclerView.setAdapter(adapter);
    }

    class URLJson extends AsyncTask<String, String, String> {
        public String json = "";
        public String string;
        Context context;

        public URLJson(Context context){
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... s) {
            try {
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
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                mData = JsonUtils.parseMovieJson(s);
                setupAdapter();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(String... text) {

        }
    }
}




