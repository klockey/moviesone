package com.example.moviesone;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.moviesone.model.Movie;
import com.squareup.picasso.Picasso;

public class DescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
    private static final String Tag = "DescriptionActivity";

   protected void onCreate(@Nullable Bundle savedInstanceState){

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_description);
       Log.d(Tag,"oncCreate: started");
       Movie m = (Movie) getIntent().getSerializableExtra("movie");
       System.out.println("movie name   " + m.getOriginal_title() );
       System.out.println(" movie synopsis " +  m.getPlot_synopsis());

       ImageView posterImage = (ImageView) findViewById(R.id.poster_image_iv);

       Picasso.get().load("https://image.tmdb.org/t/p/w185" + m.getPoster_path())
               .into(posterImage);
       TextView originalTitleTextView = (TextView) findViewById(R.id.original_title_tv);
       originalTitleTextView.setText(m.getOriginal_title());
       TextView plotSynopsisTextView = (TextView) findViewById(R.id.plot_synopsis_tv);
       plotSynopsisTextView.setText(m.getOverview());
       TextView userRatingTextView = (TextView) findViewById((R.id.user_rating_tv));
       userRatingTextView.setText(m.getVote_average());
       TextView releaseDateTextView = (TextView) findViewById((R.id.release_date_tv));
       releaseDateTextView.setText(m.getRelease_date());

       System.out.println("release date " + m.getRelease_date());

   }
}
