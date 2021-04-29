package com.example.my37_youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {
    private static final String TAG = "main:MainActivity";
    YouTubePlayerView playerView;
    YouTubePlayer player;

    private static String API_KEY = "AIzaSyAJvreLTi_thqUNER5wNuRU0J0RbQnD8tM";
    private static String videoID = "hQrEGhOjgUg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPlayer();
        
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo();
            }
        });
    }

    private void playVideo() {
        if(player != null){
            if(player.isPlaying()){
                player.pause();
            }
            player.cueVideo(videoID);
        }

    }

    private void initPlayer() {
        playerView = findViewById(R.id.playerView);
        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                player = youTubePlayer;
                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                    @Override
                    public void onLoading() {

                    }

                    @Override
                    public void onLoaded(String id) {
                        Log.d(TAG, "onLoaded: " + id);
                        player.play();
                    }

                    @Override
                    public void onAdStarted() {

                    }

                    @Override
                    public void onVideoStarted() {

                    }

                    @Override
                    public void onVideoEnded() {

                    }

                    @Override
                    public void onError(YouTubePlayer.ErrorReason errorReason) {

                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

    }
}