package com.example.my12_lifrcycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.my12_lifrcycle.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main:MainActivity";

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate : 호출됨");

        // 새창 띄우기
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        com.example.my12_lifrcycle.SubActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart : 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop : 호출됨");
        savePersonal();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy : 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause : 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume : 호출됨");
        loadPersonal();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart : 호출됨");
    }

    private  void savePersonal() {
        SharedPreferences pref = getSharedPreferences("personal", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id", "하이이이");
        editor.putInt("pw", 1234);
        editor.commit();
    }
    private void loadPersonal() {
        SharedPreferences pref = getSharedPreferences("personal", Activity.MODE_PRIVATE);
        if(pref != null){
            String id = pref.getString("id", "CSS");
            int pw = pref.getInt("pw", 0);

            Log.d(TAG, "loadPersonal: 가져온 값은 : " + id + pw);
        }
    }
}