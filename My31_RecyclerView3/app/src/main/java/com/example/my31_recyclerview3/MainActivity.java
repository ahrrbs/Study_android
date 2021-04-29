package com.example.my31_recyclerview3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SingerAdapter adapter;
    ArrayList<SingerDTO> dtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 반드시 생성해서 어댑터에 넘겨야 함
        dtos = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);

        // 리사이클러뷰에서 반드시 초기화 시켜야함
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, RecyclerView.VERTICAL, false
        );
        recyclerView.setLayoutManager(layoutManager);

        // 어댑터 객체를 생성한다
        adapter = new SingerAdapter(dtos, MainActivity.this);

        // 어댑터에 있는 ArrayList에 dto를 5개 추가한다
        adapter.addDto(new SingerDTO("네네치킨", "062-375-4492",
                "화정4동927-1", "쇼킹핫 & 스노윙", R.drawable.nene));
        adapter.addDto(new SingerDTO("BHC", "062-432-9982",
                "광주 서구 월드컵4강로28번길 14", "뿌링클", R.drawable.bhc));
        adapter.addDto(new SingerDTO("굽네", "062-384-9288",
                "광주 서구 염화로 121-1 굽네치킨 광주화정점", "고추바사삭", R.drawable.gob));
        adapter.addDto(new SingerDTO("처갓집", "0504-0544-9145",
                "광주 서구 염화로40번길 20-1", "슈프림 양념치킨", R.drawable.house));
        adapter.addDto(new SingerDTO("비비큐", "062-382-9050",
                "광주 서구 염화로 122 1층", "황금 올리브", R.drawable.bbq));
        adapter.addDto(new SingerDTO("프라닭", "062-372-9206",
                "광주 서구 화운로125번길 1 1층(화정동)", "고추마요", R.drawable.puradak));
        // 만든 어댑터를 리스트뷰에 붙인다
        recyclerView.setAdapter(adapter);

        //어댑터에 있는 클릭리스너를 이용해 클릭한 위치의 dto를 가져온다
        adapter.setOnItemClickListener(new OnSingerItemClickListener() {
            @Override
            public void onItemClick(SingerAdapter.ViewHolder holderm, View view, int position) {
                SingerDTO dto = adapter.getItem(position);
                Toast.makeText(MainActivity.this, "인기 메뉴 : " + dto.getMost(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}