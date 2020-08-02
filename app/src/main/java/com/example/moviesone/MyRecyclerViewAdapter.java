package com.example.moviesone;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.BreakIterator;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
     String [] mData;
    // String[] mData;
     LayoutInflater inflater;
     View view;
    private static final String Tag = "DescriptionActivity";


    public MyRecyclerViewAdapter(Context context, String[] mData) {
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

        //  holder.imageView.setImageResource(mData[position]); **
        Picasso.get().load(mData[position])
                     .into(holder.imageView);
        System.out.println("click");

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
            context.startActivity(intent);
        }
    }

}
