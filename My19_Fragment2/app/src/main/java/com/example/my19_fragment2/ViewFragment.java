package com.example.my19_fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewFragment extends Fragment {

    MainActivity activity;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.view_fragment, container, false);

        activity = (MainActivity) getActivity();
        imageView = rootView.findViewById(R.id.imageView);







        return rootView;
    }

   /* public void ImageChage(int state){
        if(state == 1){
            imageView.setImageResource(R.drawable.image01);
        } else if(state == 2) {
            imageView.setImageResource(R.drawable.image02);
        }
    }*/
    public void ImageChange(int resID){
        imageView.setImageResource(resID);
    }
}
