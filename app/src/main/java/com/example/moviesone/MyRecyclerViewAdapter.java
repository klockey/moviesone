package com.example.moviesone;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesone.utils.JsonUtils;
import com.example.moviesone.utils.URLJson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.text.BreakIterator;
import com.example.moviesone.model.Movie;
import java.util.concurrent.ExecutionException;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
      // String [] mData;
    // String[] mData;

     Movie[] mData;
     LayoutInflater inflater;
     View view;
     Movie movie;

    private static final String Tag = "DescriptionActivity";


    public MyRecyclerViewAdapter(Context context, Movie[] mData) {
         inflater = LayoutInflater.from(context);
         this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate (R.layout.recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Log.d(Tag,"onBindViewHolder");
        String response;
        String s = null;
      //  movie = new Movie();
        //  holder.imageView.setImageResource(mData[position]); **
      //  Picasso.get().load("https://image.tmdb.org/t/p/w185/" + mData[position].getPoster_path())
     //                .into(holder.imageView);

       // String response;
    //    String [] r = new String[] { "http://api.themoviedb.org/3/movie/top_rated?api_key=4fffd63b70b5220ca4f07dd0add06a45" };
    //    URLJson u = new URLJson();
        //URL url = new URL("http://api.themoviedb.org/3/movie/top_rated?api_key=4fffd63b70b5220ca4f07dd0add06a45");

//        try {
//            s = new URLJson().execute().get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //  String json =  JsonUtils.parseMovieJson("https://api.themoviedb.org/3/movie/top_rated?api_key=4fffd63b70b5220ca4f07dd0add06a45");
        System.out.println("s" + s);
    }


    @Override
    public int getItemCount() {
        return mData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //TextView tv;

        Context context;

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
        }

        @Override
        public void onClick(View v) {
            System.out.println("click");
            Intent intent = new Intent(context, DescriptionActivity.class);
        //    intent.putExtra("movie", movie);
            context.startActivity(intent);
        }
    }

}
