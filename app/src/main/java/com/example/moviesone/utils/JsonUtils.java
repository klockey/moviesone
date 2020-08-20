package com.example.moviesone.utils;

import com.example.moviesone.model.Movie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Movie[] parseMovieJson(String json) throws JSONException {
        System.out.println(json);
        JSONObject obj = new JSONObject(json);
        JSONArray recs = obj.getJSONArray("results");
        Movie[] movies = new Movie[recs.length()];

        for (int i=0; i < recs.length(); i++) {
            movies[i] = new Movie();
            movies[i].setPopularity(recs.getJSONObject(i).getString("popularity"));
            movies[i].setVote_count(recs.getJSONObject(i).getString("vote_count"));
            movies[i].setVideo(recs.getJSONObject(i).getString("video"));
            movies[i].setPoster_path(recs.getJSONObject(i).getString("poster_path"));
            movies[i].setId(recs.getJSONObject(i).getString("id"));
            movies[i].setAdult(recs.getJSONObject(i).getString("adult"));
            movies[i].setBackdrop_path(recs.getJSONObject(i).getString("backdrop_path"));
            movies[i].setOriginal_language(recs.getJSONObject(i).getString("original_language"));
            movies[i].setOriginal_title(recs.getJSONObject(i).getString("original_title"));
            movies[i].setGenre_id(recs.getJSONObject(i).getString("genre_ids"));
            movies[i].setTitle(recs.getJSONObject(i).getString("title"));
            movies[i].setVote_average(recs.getJSONObject(i).getString("vote_average"));
            movies[i].setOverview(recs.getJSONObject(i).getString("overview"));
            movies[i].setRelease_date(recs.getJSONObject(i).getString("release_date"));
        }

        return movies;
    }
}
