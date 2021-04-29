package com.example.my43_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    BackgroundTask backgroundTask;
    ProgressBar progressBar;
    int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar2);

        findViewById(R.id.btnexe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundTask = new BackgroundTask(progressBar, value);
                backgroundTask.execute();
            }
        });

        findViewById(R.id.btncancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(backgroundTask != null){
                    backgroundTask.cancel(true);
                }

            }
        });
    }
}