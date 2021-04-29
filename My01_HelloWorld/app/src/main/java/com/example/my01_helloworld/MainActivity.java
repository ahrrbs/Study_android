package com.example.my01_helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etPhoneNum;
    Button btnCall;
    Button Newbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //xml에 선언된 위젯젯
       etPhoneNum = findViewById(R.id.editText);
       btnCall = findViewById(R.id.btnCall);
       Newbtn = findViewById(R.id.Newbtn);

       btnCall.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String phoneNum = "tel:" + etPhoneNum.getText().toString();
               Intent intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse(phoneNum));
                startActivity(intent);
           }
       });

       Newbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

       findViewById(R.id.Newbtn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), SubActivity2.class);
               startActivity(intent);
           }
       });


}

    public void onBtn1Clicked(View view){
        Toast.makeText(this, "버튼1일 눌러졌음", Toast.LENGTH_SHORT).show();
    }
    public void onBtn2Clicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }
    public void onBtnCall(View view){

    }
}