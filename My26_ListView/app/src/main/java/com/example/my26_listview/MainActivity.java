package com.example.my26_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        listView = findViewById(R.id.listview);
        ArrayList<String> list = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selItem = (String) parent.getItemAtPosition(position);

                textView.setText(selItem);
            }
        });

        list.add("바나나");
        list.add("사과");
        list.add("딸기");
        list.add("복숭아");
        list.add("참외");
        list.add("멜론론");
        list.add("파인애플");
        list.add("제육볶음");
        list.add("우동");
        list.add("짬뽕");
        list.add("탕수육");
        list.add("깐풍기");
        list.add("피자");





    }
}