package com.example.billy.leagueofstats;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

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

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... voids) {
        int count;
        BufferedReader reader = null;

        try {
            //fasdf asdf sad
            URL url = new URL("http://stucom.flx.cat/lego/get_set_parts.php?set=60115-1&key=62fb8715af2c04f5d9a3d69bdde21e65");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int lengthOfFile = connection.getContentLength();
            int responseCode = connection.getResponseCode();
            Log.e("funciona", "hasta aqui");
            if (responseCode == 200) {
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    output.write(data, 0, count);
                }
                input.close();
                output.flush();
            }
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
