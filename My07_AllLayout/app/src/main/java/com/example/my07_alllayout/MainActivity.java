package com.example.my07_alllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button7, button8;
    ImageView imageView1, imageView2, imageView3, imageView4;
    int selImg = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.GONE);
        imageView3.setVisibility(View.VISIBLE);
        imageView4.setVisibility(View.GONE);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selImg == 1) {
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.GONE);
                    selImg = 2;
                } else if(selImg == 2) {
                    imageView1.setVisibility(View.GONE);
                    imageView2.setVisibility(View.VISIBLE);
                    selImg = 1;
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selImg == 1) {
                    imageView3.setVisibility(View.VISIBLE);
                    imageView4.setVisibility(View.GONE);
                    selImg = 2;
                } else if(selImg == 2) {
                    imageView3.setVisibility(View.GONE);
                    imageView4.setVisibility(View.VISIBLE);
                    selImg = 1;
                }
            }
        });


    }
}
