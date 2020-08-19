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
    //  JSONObject locs = obj.getJSONObject();
        JSONArray recs = obj.getJSONArray("results");
        // JSONObject locs = recs.getJSONObject(0);
        // System.out.println(locs.getString("poster_path"));

        System.out.println(recs);
        Movie[] movies = new Movie[recs.length()];

        String recs2;

        recs2 = recs.getJSONObject(0).getString("original_title");
        Movie movie = new Movie();
        movie.setOriginal_title(recs2);

        movies[0] = movie;

        return movies;
    }
}
