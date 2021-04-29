package com.example.my33_audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String Audio_url = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";
    MediaPlayer mediaPlayer;

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palyAudio(Audio_url);
                palyAudio1(R.raw.m01);
                Toast.makeText(MainActivity.this, "노래 재생", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer !=null){
                    mediaPlayer.stop();
                    Toast.makeText(MainActivity.this, "노레 정지", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer !=null){
                    position = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                    Toast.makeText(MainActivity.this, "노레 일시정지", Toast.LENGTH_SHORT).show();
                }

            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer !=null && !mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    mediaPlayer.seekTo(position);
                }

            }
        });
    }

    private void palyAudio1(int resID) {
        killMediaPlayer();

        try {
            mediaPlayer = new MediaPlayer();
           mediaPlayer = MediaPlayer.create(getApplicationContext(), resID);
           mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void palyAudio(String Audio_url){
        killMediaPlayer();

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(Audio_url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private void killMediaPlayer() {
        if(mediaPlayer !=null){
            mediaPlayer.release();
        }
    }
}