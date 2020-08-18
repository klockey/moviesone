package com.example.moviesone.utils;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLJson extends AsyncTask <String, String, String> {
    public String json = "";
    public String string;

    @Override
    protected String doInBackground(String[] strings) {
        try {
            StringBuffer response;
            URL obj = new URL(strings[0]);
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

                System.out.println(response.toString());
                json = response.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("**************");
        }
        return json;
    }

    protected void onProgressUpdate(Integer... progress) {
        setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
        showDialog("Downloaded " + result + " bytes");
    }

}

