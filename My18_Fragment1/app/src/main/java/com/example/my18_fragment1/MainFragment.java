package com.example.my18_fragment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    MainActivity activity;

    //프래그먼트 화면 붙이기 : 반드신 onCreateView를
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        rootView.findViewById(R.id.btnMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 자신이 속한 activity를 알게한다 : 여거서는 매인 액티비티
                activity = (MainActivity) getActivity();

                activity.onFragmentChange(1);
            }
        });

        return rootView;


    }


}
