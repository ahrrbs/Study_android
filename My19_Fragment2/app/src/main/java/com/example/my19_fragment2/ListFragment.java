package com.example.my19_fragment2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    MainActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;

    }

    //프래그먼트 화면 붙이기 : 반드신 onCreateView를
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.list_fragment, container, false);

        rootView.findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 자신이 속한 activity를 알게한다 : 여거서는 매인 액티비티
                activity.onImageSelected(R.drawable.image01);
            }
        });
        rootView.findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 자신이 속한 activity를 알게한다 : 여거서는 매인 액티비티
                activity.onImageSelected(R.drawable.image02);
            }
        });

        return rootView;


    }
}
