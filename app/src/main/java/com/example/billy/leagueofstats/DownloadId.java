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
    private JSONObject jsonObject;
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
           /* URL url = new URL("https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/bimu?api_key=RGAPI-3a39327e-3d10-42c6-87b6-eb4ef96168a3");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int lengthOfFile = connection.getContentLength();
            int responseCode = connection.getResponseCode();
            String a = connection.getContent().toString();*/
            String url = "https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/bimu?api_key=RGAPI-3a39327e-3d10-42c6-87b6-eb4ef96168a3";
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e("", "Response from url: " + jsonStr);
          //  if (responseCode == 200) {
               /* InputStream input = new BufferedInputStream(url.openStream(), 8192);
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    output.write(data, 0, count);
                }
                input.close();
                output.flush();
                jsonObject = new JSONObject(output.toString());
                Log.e("json: ", jsonObject.toString());*/
           // }
           /* this.xml = new String(output.toByteArray());
            Log.e("xml: ", xml);
            reader = new BufferedReader(new StringReader(xml));*/
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