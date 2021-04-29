package com.example.my27_listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView listView;

    SingerAdapter adapter;
    ArrayList<SingerDto> dtos;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //디바이스 사이즈 구하기
        Point size = getDeviceSize();
        
        dtos = new ArrayList<>();

        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        // 어댑터 객체를 생성한다
        adapter = new SingerAdapter(MainActivity.this, dtos, size);

        // 어댑터에 있는 ArrayList에 dto를 5개 추가한다
        adapter.addDto(new SingerDto("블랙핑크", "010-1111-1111",
                25, R.drawable.singer1));
        adapter.addDto(new SingerDto("걸스데이", "010-1111-2222",
                27, R.drawable.singer2));
        adapter.addDto(new SingerDto("방탄소년단", "010-1111-3333",
                22, R.drawable.singer3));
        adapter.addDto(new SingerDto("마마무", "010-1111-4444",
                30, R.drawable.singer4));
        adapter.addDto(new SingerDto("소녀시대", "010-1111-5555",
                28, R.drawable.singer5));
        // 만든 어댑터를 리스트뷰에 붙인다
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerDto dto = (SingerDto) adapter.getItem(position);

                Toast.makeText(MainActivity.this, "선택 : " + position
                        + "\n이름 : " + dto.getName() + "\n전화번호 : " + dto.getMobile()
                        + "\n나이 : " + dto.getAge() + "\n이미지 : " + dto.getResId()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 어댑터에 있는 ArrayList에 dto를 1개 추가
                adapter.addDto(new SingerDto("박효신", "010-1111-6666",
                        31, R.drawable.dream03));
                // 화면갱신
                adapter.notifyDataSetChanged();
            }
        });
    }

    public Point getDeviceSize(){
        Display display = getWindowManager().getDefaultDisplay(); //in activity
        /*getActivity().getWindowManager().getDefaultDisplay(); */ //in fragment

        Point size = new Point();
        display.getRealSize(size);
        
        int width = size.x; // 디바이스 넓이
        int height = size.y;

        return size;
    }
}

















