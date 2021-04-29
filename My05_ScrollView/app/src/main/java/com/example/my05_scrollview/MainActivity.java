package com.example.my05_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Drawable myImage = getResources().getDrawable(R.drawable.image01);
                /*imageView.setImageResource(R.drawable.image02);*/
                R.drawable.image01 myIamge ? imageView.setImageResource(R.drawable.image02);
            }
        });
    }
}