package com.example.my24_tab3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Fragment3 extends Fragment {

    MainActivity activity;
    String sendData, receiveData;
    Person person3;

    Button button3;
    TextView textView3;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        //프래그먼트가 속한 액티비티 가져옴
        activity = (MainActivity) getActivity();
        //프래그먼트3에서 보낼 문자열
        sendData = "프래그먼트3에서 보낸 데이터입니다.";
        person3 = new Person("Kang", 33);
        //프래그먼트2에서 받을 문자열 초기화
        receiveData = "";
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        textView3 = viewGroup.findViewById(R.id.textView3);
        button3 = viewGroup.findViewById(R.id.button3);

        //프래그먼트2에서 데이터 받기
        if(activity.mbundle !=null){
            Bundle bundle = activity.mbundle;
            receiveData = bundle.getString("sendData");
            Person person2 = (Person) bundle.getSerializable("person2");
            String name = person2.getName();
            int age = person2.getAge();

            textView3.setText(receiveData + "\n");
            textView3.append("name : " + name + "\nage : " + age);

            activity.mbundle = null;

        }

        //프래그먼트1로 데이터 보내기
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("sendData", sendData);
                bundle.putSerializable("person3", person3);
                bundle.putInt("index", 2);

                //매인 액티비티에 번들 만들어서 보내기
                activity.fragBtnClick(bundle);

                //프래그먼트1로 화면 전환
                TabLayout.Tab tab = activity.tabs.getTabAt(0);
                tab.select();


            }
        });







        return viewGroup;
    }
}
