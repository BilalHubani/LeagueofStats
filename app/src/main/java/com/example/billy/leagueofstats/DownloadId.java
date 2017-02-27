package com.example.billy.leagueofstats;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dam on 24/2/17.
 */
public class DownloadId extends AsyncTask<Void, String, String> {
    private Context context;
    private OnInfoLoadedListener listener = null;
    public void setOnInfoLoadedListener(OnInfoLoadedListener listener) {
        this.listener = listener;
    }

    public DownloadId() {
    }

    @Override
    protected void onPreExecute() {
        Log.e("Entra en pre","yeah");
    }

    @Override
    protected String doInBackground(Void... voids) {
        int count;
        BufferedReader reader = null;
        try {
            String url = "https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/bimu?api_key=RGAPI-3a39327e-3d10-42c6-87b6-eb4ef96168a3";
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            if (jsonStr.equals("Not found") || jsonStr.equals("error")) {
                // no funca
            }else {
                //si funca
                JSONObject jsonObject = new JSONObject(jsonStr);
                JSONObject s = jsonObject.getJSONObject("bimu");
                Summoner summoner = new Summoner();
                summoner.setId(s.getString("id"));
                summoner.setName(s.getString("name"));
                summoner.setIconId(s.getString("profileIconId"));
                summoner.setLvl(s.getString("summonerLevel"));
                System.out.println(summoner);
            }
        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }
        return null;
    }



    @Override
    protected void onPostExecute(String s) {
        if (listener != null) listener.onInfoLoaded(true);
    }
}