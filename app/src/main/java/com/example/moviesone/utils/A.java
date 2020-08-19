//package com.example.moviesone.utils;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.AsyncTask;
//
//import com.example.moviesone.MainActivity;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//
//public class A extends Activity {
//
//    public String a = "yes";
//
// public class URLJson extends AsyncTask<String, String, String> {
//    public String json = "";
//    public String string;
//     Context context;
//
//    @Override
//    protected void onPreExecute() {
//    }
//
//    @Override
//    protected String doInBackground(String... s) {
//        try {
//            StringBuffer response;
//            URL obj = new URL("https://api.themoviedb.org/3/movie/top_rated?api_key=4fffd63b70b5220ca4f07dd0add06a45");
//            HttpURLConnection con = null;
//            if (Network.isOnline()) {
//                con = (HttpURLConnection) obj.openConnection();
//
//                BufferedReader in = new BufferedReader(new InputStreamReader(
//                        con.getInputStream()));
//                String inputLine;
//                response = new StringBuffer();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                System.out.println(response.toString());
//                json = response.toString();
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("**************");
//        }
//        return "hello";
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//
//
//    }
//
//    @Override
//    protected void onProgressUpdate(String... text) {
//
//
//    }
//
//}
//
//}
