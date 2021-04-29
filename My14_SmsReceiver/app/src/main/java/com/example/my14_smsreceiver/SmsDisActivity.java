package com.example.my14_smsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmsDisActivity extends AppCompatActivity {

    Button btnSender;
    Button btnClose;
    TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_dis);

        txtContent = findViewById(R.id.txtContents);
        btnSender = findViewById(R.id.btnSender);

        findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        Intent disIntent = getIntent();
        processIntent(disIntent);
    }
    private void processIntent(Intent disIntent){
        String sender = disIntent.getStringExtra("sender");
        String receicedDate = disIntent.getStringExtra("receicedDate");
        String contents = disIntent.getStringExtra("contents");
        
        if(sender != null){
            btnSender.setText(sender + "에서 문자 수신");
            txtContent.setText("[" + receicedDate + "]\n" + contents);
        }
    }
    
    //기존 화면이 사용하고자 할때 onCreate()를 사용하지 못해서 onNewIntent() 매소드를 사용하여 새로운intent를 받아 화면을 갱신
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        processIntent(intent);
    }
}