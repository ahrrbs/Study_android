package com.example.my19_fragment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListFragment listFragment;
    ViewFragment viewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFragment);
        viewFragment = (ViewFragment) getSupportFragmentManager().findFragmentById(R.id.viewerFragment);
    }

    public void onImageSelected(int resID){

        viewFragment.ImageChange(resID);
    }

}