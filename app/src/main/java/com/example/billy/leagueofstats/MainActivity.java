package com.example.billy.leagueofstats;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText summoner;
    Button button;
    DownloadId di;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        summoner = (EditText)findViewById(R.id.summoner);
        button = (Button)findViewById(R.id.searchButton);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                summoner.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);
                Log.e("Entra en antes","yeah");
                di = new DownloadId();
                di.setOnInfoLoadedListener(new OnInfoLoadedListener() {
                    @Override
                    public void onInfoLoaded(boolean ok) {
                        Log.e("","acaba");
                    }
                });
            }
        });
    }
    public void Wait(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                progressBar.setVisibility(View.GONE);
                spinner.setVisibility(View.VISIBLE);
                summoner.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);

            }
        }, milisegundos);
    }
}
