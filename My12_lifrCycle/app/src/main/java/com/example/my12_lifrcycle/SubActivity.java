package com.example.my12_lifrcycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.my12_lifrcycle.R;

public class SubActivity extends AppCompatActivity {

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 메인으로 돌아가기 : 서브화면을 종료시키면 된다.
        findViewById(R.id.btnreturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}