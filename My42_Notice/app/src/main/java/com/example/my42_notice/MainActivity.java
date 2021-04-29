package com.example.my42_notice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager manager;

    //오레오 버전 이후는 알림 채널을 생성해서 줘야 한다.
    String Channel_id1 = "channel1";
    String Channel_Name1 = "channel1";

    String Channel_id2 = "channel2";
    String Channel_Name2 = "channel2";

    String Channel_id3 = "channel3";
    String Channel_Name3 = "channel3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti1();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti2();
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void showNoti1() {
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if(manager.getNotificationChannel(Channel_id1) == null){
                manager.createNotificationChannel(new NotificationChannel(
                        Channel_id1, Channel_Name1, NotificationManager.IMPORTANCE_DEFAULT
                ));
            }
            builder = new NotificationCompat.Builder(this, Channel_id1);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        builder.setContentTitle("간단알람").setContentText("간단알림 메세지입니다.")
                .setSmallIcon(android.R.drawable.ic_menu_view);
        Notification noti = builder.build();
        manager.notify(1,noti);
    }
    private void showNoti2() {
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if(manager.getNotificationChannel(Channel_id2) == null){
                manager.createNotificationChannel(new NotificationChannel(
                        Channel_id2, Channel_Name2, NotificationManager.IMPORTANCE_DEFAULT
                ));
            }
            builder = new NotificationCompat.Builder(this, Channel_id2);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        //펜딩인텐트 객체에 띄울 액티비티를 파라메터로 보낸다
        // 펜딩인텐트는 특정시점에서 어떤 행동을 하도록 할 수 있다.
        Intent intent = new Intent(this, SubActivity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1001, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentTitle("간단 알림 클릭").setContentText("클릭 아림 메세지입니다.")
                .setSmallIcon(android.R.drawable.ic_menu_view)
                .setAutoCancel(true) //알림을 클릭하면 자동으로 알림이 사라짐
                .setContentIntent(pendingIntent);
        Notification noti = builder.build();
        manager.notify(2, noti);

    }}