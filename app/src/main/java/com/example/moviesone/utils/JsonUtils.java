package com.example.moviesone.utils;

import com.example.moviesone.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Movie[] parseMovieJson(String json) throws JSONException {
 
        JSONObject obj = new JSONObject(json);
        String page;
        page = obj.optString("page");
    //    JSONObject locs = obj.getJSONObject();
        JSONArray recs = obj.getJSONArray("results");
        // JSONObject locs = recs.getJSONObject(0);
        // System.out.println(locs.getString("poster_path"));

        System.out.println(recs);
        Movie[] movies = new Movie[recs.length()];
        String recs2;

        recs2 = recs.getJSONObject(0).getString("original_title");
        movies[0].setOriginal_title(recs2);

//        for (int i = 0; i < movies.length;i++) {
//            recs2 = recs.getJSONObject(i).getString("original_title");
//            movies[i].setOriginal_title(recs2);
//           // System.out.println(movies[i].getId())
//              System.out.println(recs2);
////            movies[i].setPoster_path(recs.getJSONObject(i).getString("poster_path"));
////            movies[i].setPlot_synopsis(recs.getJSONObject(i).getString("overview"));
////            movies[i].setUser_rating(recs.getJSONObject(i).getString("vote_average"));
////            movies[i].setRelease_date(recs.getJSONObject(i).getString("release_date"));
////        }
//        }
        return movies;
    }
}
