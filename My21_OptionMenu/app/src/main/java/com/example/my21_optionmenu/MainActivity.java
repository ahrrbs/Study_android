package com.example.my21_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActionBar abar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abar = getSupportActionBar();
        //액션바 숨기기 : values -> themes
        /*abar.hide();*/

        //액션바의 타이틀부분 로고 바꾸기
        abar.setLogo(R.drawable.back);
        abar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);

        //타이틀로고 클릭이벤트 만들기
        //그리고 onOptionItemSelected()에 추가
        abar.setDisplayHomeAsUpEnabled(true);
    }

    //액션바에 옵션메뉴 붙이기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_option, menu);

        return true;
    }

    //옵션 메뉴 클릭이벤트 만들기
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int curId = item.getItemId();

        switch (curId){
            case R.id.menu_refresh:
                Toast.makeText(this, "새로고침 메뉴가 눌림", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "검색 메뉴가 눌림", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this, "세팅 메뉴가 눌림", Toast.LENGTH_SHORT).show();
                break;
            // 액션바에 있는 뒤로가기 화살표를 클릭했을떄
            case android.R.id.home:
                Toast.makeText(this, "홈 메뉴가 눌림", Toast.LENGTH_SHORT).show();
                this.finish();
                break;
        }

        return true;
    }
}