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
//import com.example.moviesone.utils.URLJson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.text.BreakIterator;
import com.example.moviesone.model.Movie;
import java.util.concurrent.ExecutionException;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    Movie[] mData;
    LayoutInflater inflater;
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

    //    Picasso.get().load("https://image.tmdb.org/t/p/w185/" + mData[position].getPoster_path())
      //          .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
       // return mData.length;
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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
            context.startActivity(intent);
        }
    }

}
